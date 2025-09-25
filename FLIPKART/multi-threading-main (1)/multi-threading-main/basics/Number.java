package basics;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Number {
    static int count = 1;
    static boolean readyForComma = false;
    static Object lock = new Object();
    static int max = 50;



    public static void main(String[] args) throws InterruptedException {

        Thread oddNumber = new Thread(() ->{
            while (count <= max) {
                synchronized (lock) {
                    while (readyForComma || count % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(count++);
                    readyForComma = true;
                    lock.notifyAll();
                }
            }


        });

        Thread evenNumber = new Thread(() ->{
            while (count <= max) {
                synchronized (lock) {
                    while (readyForComma || count % 2 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(count++);
                    readyForComma = true;
                    lock.notifyAll();
                }
            }


        });

        Thread comma = new Thread(() ->{

            while (count <= max-1) {
                synchronized (lock) {
                    while (!readyForComma) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(",");
                    readyForComma = false;
                    lock.notifyAll();
                }
            }
        });


            oddNumber.start();
            comma.start();
            evenNumber.start();






    }
}
