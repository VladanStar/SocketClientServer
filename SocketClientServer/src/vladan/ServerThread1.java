package vladan;

import java.io.*;
import java.net.Socket;

public class ServerThread1 extends Thread {
    private Socket sock;
    private int value;
    private BufferedReader in;
    private PrintWriter out;

    public ServerThread1(Socket sock, int value) {
        this.sock = sock;
        this.value = value;
        try {
            in = new BufferedReader( // inicijalizuj ulazni stream
                    new InputStreamReader(
                            sock.getInputStream()));
            out = new PrintWriter( // inicijalizuj izlazni stream
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    sock.getOutputStream())), true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        start();
    }

    public void run() {
        try {
// procitaj zahtev
            String request = in.readLine();
// odgovori na zahtev
            out.println("(" + value + ")");
// zatvori konekciju
            in.close();
            out.close();
            sock.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}