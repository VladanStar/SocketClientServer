package vladan;

import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public static final int TCP_PORT =8080;

    public static void main(String[] args) {
        try {
            int clientCounter = 0;
            ServerSocket ss = new ServerSocket(TCP_PORT);
            System.out.println("Server running...");
            while (true) {
                Socket sock = ss.accept();
                System.out.println("Client accepted:" + (++clientCounter));
                ServerThread1 st = new ServerThread1(sock, clientCounter);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
