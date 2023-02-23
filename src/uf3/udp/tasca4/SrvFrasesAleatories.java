package uf3.udp.tasca4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.ByteBuffer;

public class SrvFrasesAleatories {
    MulticastSocket socket;
    InetAddress multicastIP;
    int port;
    boolean continueRunning = true;
    FrasesAleatories fraseator;
    byte[] fraseAleatoria;

    public SrvFrasesAleatories(int portValue, String strIp) throws IOException {
        socket = new MulticastSocket(portValue);
        multicastIP = InetAddress.getByName(strIp);
        port = portValue;
        fraseator = new FrasesAleatories();
    }

    public void runServer() throws IOException{
        DatagramPacket packet;
        byte[] sendingData;

        while(continueRunning){
            sendingData = fraseator.agafaFraseAleatoria().getBytes();
            packet = new DatagramPacket(sendingData, sendingData.length, multicastIP, port);
            socket.send(packet);

            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                ex.getMessage();
            }
        }
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        //Canvieu la X.X per un número per formar un IP.
        //Que no sigui la mateixa que la d'un altre company
        SrvFrasesAleatories srvFrasesAleatories = new SrvFrasesAleatories(5557, "224.0.11.111");
        srvFrasesAleatories.runServer();
        System.out.println("Parat!");
    }
}