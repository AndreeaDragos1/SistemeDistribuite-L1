import java.io.*;
import java.net.*;

public class P3 {
    public static void main(String[] args) throws IOException {
        // Primire mesaj de la P2 pe localhost:5003
        ServerSocket serverSocket = new ServerSocket(5003);
        Socket incoming = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
        System.out.println("P3 a primit: " + in.readLine());

        // Trimitere mesaj la P1 pe localhost:5001
        Socket socket = new Socket("127.0.0.1", 5001);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Mesaj de la P3");

        incoming.close();
        serverSocket.close();
        socket.close();
    }
}
