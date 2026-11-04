package thread;

import com.sun.jdi.event.ThreadDeathEvent;

public class demo1 {
    static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 5 ; i++) {
                    System.out.println("子线程在干活");
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t1 = new Thread(task);
        t1.start();

        for (int i = 0; i <=5 ; i++) {
            System.out.println("主线程在干活");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
