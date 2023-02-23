package uf3.udp.tasca2;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Scanner;

public class DatagramSocketClient {
    InetAddress serverIP;
    int serverPort;
    DatagramSocket socket;
    Scanner sc = new Scanner(System.in);
    int codi;
    SecretNum sn = new SecretNum();

    public static void main(String[] args) throws IOException {
        DatagramSocketClient dsc = new DatagramSocketClient();
        dsc.init("localhost", 5555);
        dsc.runClient();
    }
    public void init(String host, int port) throws IOException {
        serverIP = InetAddress.getByName(host);
        serverPort = port;
        socket = new DatagramSocket();
    }

    public void runClient() throws IOException {
        byte [] receivedData = new byte[1024];
        byte [] sendingData;

        //a l'inici
        sendingData = getFirstRequest();

        //el servidor atén el port indefinidament
        while(mustContinue(sendingData)){
            DatagramPacket packet = new DatagramPacket(sendingData,
                    sendingData.length,
                    serverIP,
                    serverPort);

            //enviament de la resposta
            socket.send(packet);

            //creació del paquet per rebre les dades
            packet = new DatagramPacket(receivedData, 1024);

            //espera de les dades
            socket.receive(packet);

            //processament de les dades rebudes i obtenció de la resposta
            sendingData = getDataToRequest(packet.getData(), packet.getLength());
        }
    }

    private byte[] getDataToRequest(byte[] data, int length) {
        System.out.println("<"+codi+"> Resposta del servidor: " + sn.comprova(new String(data, 0, length)));
        if(!mustContinue(data)) return null;
        System.out.print("Siusplau, escriu un número: ");
        return sc.nextLine().getBytes();
    }

    private byte[] getFirstRequest() {
        System.out.print("Siusplau, escriu un número: ");
        codi = sc.nextInt();
        return ByteBuffer.allocate(4).putInt(codi).array();
    }

    private boolean mustContinue(byte[] sendingData) {
        return !sn.comprova(Arrays.toString(sendingData)).equals("Correcte");
    }
}
