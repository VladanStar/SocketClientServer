package vladan;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {

    public static final int TCP_PORT = 8080;

    public static void main(String[] args) {
        try {
            // odredi adresu racunara sa kojim se povezujemo (ovde lokalno)
            InetAddress inetAddress = InetAddress.getByName("localhost");
            // otvori socket prema serveru
            Socket socket = new Socket("localhost", 8080);
            // inicijalizuj ulazni stream
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // inicijalizuj izlazni stream
            PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            // posalji zahtev
            System.out.println("[Client]: Hello");
            pw.println("Hello");
            // procijaj odgovor
            String response = br.readLine();
            System.out.println("[Server response]: " + response);
            // zatvori konekciju
            br.close();
            pw.close();
            socket.close();
        }
        catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
