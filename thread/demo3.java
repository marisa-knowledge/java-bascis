package thread;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class demo3 {
    static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(10086);
            System.out.println("server is listening on port 10086");

            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("client connected");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            InputStream is = socket.getInputStream();
                            byte[] buffer = new byte[1024];
                            int len = is.read(buffer);
                            System.out.println(new String(buffer, 0, len));

                            is.close();
                            socket.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
