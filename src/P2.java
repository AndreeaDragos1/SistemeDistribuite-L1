import java.io.*;
import java.net.*;

public class P2 {
    public static void main(String[] args) throws IOException {
        // Primire mesaj de la P1 pe localhost:5002
        ServerSocket serverSocket = new ServerSocket(5002);
        Socket incoming = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
        System.out.println("P2 a primit: " + in.readLine());

        // Trimitere mesaj la P3 pe localhost:5003
        Socket socket = new Socket("127.0.0.1", 5003);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Mesaj de la P2");

        incoming.close();
        serverSocket.close();
        socket.close();
    }
}
