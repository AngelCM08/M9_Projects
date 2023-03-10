package uf3.tcp.multiclient;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TcpSocketClientMulti extends Thread {
    private String Nom;
    private Socket socket;
    private InputStream in;
    private OutputStream out;
    private Scanner sc = new Scanner(System.in);;
    private boolean continueConnected;
    private Llista llista;

    private TcpSocketClientMulti(String hostname, int port) {
        try {
            socket = new Socket(InetAddress.getByName(hostname), port);
            in = socket.getInputStream();
            out = socket.getOutputStream();
        } catch (UnknownHostException ex) {
            System.out.println("Error de connexió. No existeix el host: " + ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        continueConnected = true;
    }

    public void run() {
        String valor = "Y";
        while (continueConnected) {
            llista = getRequest();
            if (llista != null) {
                System.out.println(llista.getNumberList());
                do {
                    System.out.print("Tens una llista per enviar? (si/no): ");
                    valor = sc.nextLine();
                    if (valor.equalsIgnoreCase("no")) {
                        continueConnected = false;
                    } else if (!valor.equalsIgnoreCase("si")) {
                        System.out.println("Error, envia un valor correcte!");
                    }
                } while (!valor.equalsIgnoreCase("no") && !valor.equalsIgnoreCase("si"));
            }

            if (continueConnected) {
                System.out.println("Introdueix un valor i dona enter per omplir la Llista de Integers, introdueix STOP per finalitzar:");

                List<Integer> llistaIntegers = new ArrayList<>();
                do {
                    try {
                        valor = sc.nextLine();
                        if (!Objects.requireNonNull(valor).equalsIgnoreCase("STOP"))
                            llistaIntegers.add(Integer.parseInt(valor));
                    } catch (NumberFormatException e) {
                        System.out.println("Error! No es pot introduir aquest valor a la llista!");
                    }
                } while (!Objects.requireNonNull(valor).equalsIgnoreCase("STOP"));
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(out);
                    oos.writeObject(new Llista(Nom, llistaIntegers));
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        close(socket);
    }

    private Llista getRequest() {
        try {
            ObjectInputStream ois = new ObjectInputStream(in);
            llista = (Llista) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return llista;
    }


    private void close(Socket socket) {
        try {
            //tancament de tots els recursos
            if (socket != null && !socket.isClosed()) {
                if (!socket.isInputShutdown()) {
                    socket.shutdownInput();
                }
                if (!socket.isOutputShutdown()) {
                    socket.shutdownOutput();
                }
                socket.close();
            }
        } catch (IOException ex) {
            //enregistrem l'error amb un objecte Logger
            Logger.getLogger(TcpSocketClientMulti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        String jugador, ipSrv;

        //Demanem la ip del servidor i nom del jugador
        System.out.println("Ip del servidor?");
        Scanner sip = new Scanner(System.in);
        ipSrv = sip.next();
        System.out.println("Nom Client:");
        jugador = sip.next();

        TcpSocketClientMulti tcpSocketClientMulti = new TcpSocketClientMulti(ipSrv, 5558);
        tcpSocketClientMulti.Nom = jugador;
        tcpSocketClientMulti.start();
    }
}