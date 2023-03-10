package uf3.tcp.multiclient;

import java.io.*;
import java.net.Socket;

public class ThreadServer implements Runnable {
    private Socket clientSocket = null;
    private InputStream in = null;
    private OutputStream out = null;

    public ThreadServer(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        in = clientSocket.getInputStream();
        out = clientSocket.getOutputStream();
        System.out.println("canals i/o creats amb un nou Client");
    }

    @Override
    public void run() {
        Llista llista = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(in);
            try {
                llista = (Llista) ois.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(llista.getNom() +" a enviat aquesta Llista " + llista.getNumberList());

            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(llista);
            oos.flush();
            clientSocket.close();

        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
