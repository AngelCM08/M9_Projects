package uf3.udp.tasca1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class DatagramSocketClient {
    InetAddress serverIP;
    int serverPort;
    DatagramSocket socket;
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        DatagramSocketClient dsc = new DatagramSocketClient();
        dsc.init("192.168.22.111", 2735);
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
        System.out.println("Resposta del servidor: " + new String(data, 0, length));
        System.out.print("Siusplau, escriu el següent missatge: ");
        return sc.nextLine().getBytes();
    }

    private byte[] getFirstRequest() {
        System.out.print("Siusplau, escriu el teu nom per la primera connexió: ");
        return sc.nextLine().getBytes();
    }

    private boolean mustContinue(byte[] sendingData) {
        return !new String(sendingData, 0, sendingData.length).equalsIgnoreCase("adeu");
    }
}
