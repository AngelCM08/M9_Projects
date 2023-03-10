package uf3.tcp.multiclient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TcpSocketServerMulti {
    private final int port;

    private TcpSocketServerMulti(int port) {
        this.port = port;
    }

    private void listen() {
        ServerSocket serverSocket;
        Socket clientSocket;
        try {
            serverSocket = new ServerSocket(port);
            while(true) { //esperar connexió del client i llançar thread
                clientSocket = serverSocket.accept();
                //Llançar Thread per establir la comunicació
                //sumem 1 al numero de jugadors
                ThreadServer FilServidor = new ThreadServer(clientSocket);
                Thread client = new Thread(FilServidor);
                client.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(TcpSocketServerMulti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        TcpSocketServerMulti srv = new TcpSocketServerMulti(5558);
        srv.listen();
    }
}
