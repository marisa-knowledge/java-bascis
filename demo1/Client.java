package demo1;

import java.io.OutputStream;
import java.net.Socket;

public class Client {
    static void main(String[] args) throws Exception{

        System.out.println();

        Socket socket = new Socket("127.0.0.1", 10086);

        OutputStream os = socket.getOutputStream();

        String msg = "Hello, Server!";
        os.write(msg.getBytes());

        System.out.println("Message sent to server successfully");

        os.close();
        socket.close();
    }
}
