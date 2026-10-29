package demo1;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static void main(String[] args) throws Exception{
        System.out.println("Server is listening on port 10086");

        ServerSocket serverSocket = new ServerSocket(10086);

        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        InputStream is = socket.getInputStream();

        byte[] buffer = new byte[1024];
        int len = is.read(buffer);
        System.out.println(new String(buffer, 0, len));

        is.close();
        socket.close();
        serverSocket.close();
    }
}
