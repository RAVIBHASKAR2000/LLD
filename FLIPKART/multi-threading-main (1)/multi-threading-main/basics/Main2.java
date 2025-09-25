package basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main2 {
    static Object lock = new Object();

    public static void main(String[] args) {
        List<Thread> allThreads = new ArrayList<Thread>(20);

        for(int i = 0; i < 20; i++) {
            allThreads.add(new Demo());
        }

        for (Thread thread : allThreads) {
            thread.start();
        }



    }

    public static class Demo extends Thread{
        Random rand = new Random();
        int x;

        @Override
        public void run() {
            x = rand.nextInt(100);
            System.out.println("x = "+x+" by thread"+Thread.currentThread().getName());
            synchronized (lock) {
                try {
                    System.out.println("lock acquired by : "+Thread.currentThread().getName());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

            System.out.println("got out of lock");
        }
    }
}
