package uf3.udp.tasca4;

import java.io.IOException;
import java.net.*;

public class ClientFrasesAleatories {
    private boolean continueRunning = true;
    private MulticastSocket socket;
    private InetAddress multicastIP;
    private int port;
    NetworkInterface netIf;
    InetSocketAddress group;
    String frase;

    public ClientFrasesAleatories(int portValue, String strIp) throws IOException {
        multicastIP = InetAddress.getByName(strIp);
        port = portValue;
        socket = new MulticastSocket(port);
        netIf = socket.getNetworkInterface();
        group = new InetSocketAddress(strIp,portValue);
    }

    public void runClient() throws IOException{
        DatagramPacket packet;
        byte [] receivedData = new byte[100];

        socket.joinGroup(group,netIf);
        System.out.printf("Connectat a %s:%d%n",group.getAddress(),group.getPort());

        while(continueRunning){
            packet = new DatagramPacket(receivedData, receivedData.length);
            socket.setSoTimeout(5000);
            try{
                socket.receive(packet);
                continueRunning = getData(packet.getData(), packet.getLength());
            }catch(SocketTimeoutException e){
                System.out.println("S'ha perdut la connexió amb el servidor.");
                continueRunning = false;
            }
        }
        socket.leaveGroup(group,netIf);
        socket.close();
    }

    protected boolean getData(byte[] data, int length) {
        frase = new String(data, 0, length);
        if(frase.split(" ").length > 7) System.out.println(frase);
        else System.out.println("La frase '"+frase+"' té menys de 8 paraules." );

        return true;
    }

    public static void main(String[] args) throws IOException {
        ClientFrasesAleatories cvel = new ClientFrasesAleatories(5557, "224.0.11.111");
        cvel.runClient();
        System.out.println("Parat!");

    }
}
