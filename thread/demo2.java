package thread;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class demo2 {
    static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println();

                    Socket socket = new Socket("127.0.0.1", 10086);

                    OutputStream os = socket.getOutputStream();

                    String msg = "Hello, Server!";
                    os.write(msg.getBytes());

                    System.out.println("Message sent to server successfully");
                    System.out.println("");

                    os.close();
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(task);
        t1.start();

        while (true) {
            try {

                System.out.println("Server is listening on port 10086");

                ServerSocket serverSocket = new ServerSocket(10086);

                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                InputStream is = socket.getInputStream();

                byte[] buffer = new byte[1024];
                int len = is.read(buffer);
                System.out.println(new String(buffer, 0, len));
                System.out.println("");

                is.close();
                socket.close();
                serverSocket.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
