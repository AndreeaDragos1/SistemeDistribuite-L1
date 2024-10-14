import java.io.*;
import java.net.*;

public class P1 {
    public static void main(String[] args) throws IOException {
        // Trimitere mesaj la P2 pe localhost:5002
        Socket socket = new Socket("127.0.0.1", 5002);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Mesaj de la P1");

        // Primire mesaj de la P3 pe localhost:5001
        ServerSocket serverSocket = new ServerSocket(5001);
        Socket incoming = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
        System.out.println("P1 a primit: " + in.readLine());

        socket.close();
        incoming.close();
        serverSocket.close();
    }
}
