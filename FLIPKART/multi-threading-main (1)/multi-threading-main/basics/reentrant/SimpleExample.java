package basics.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SimpleExample {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread thread = new Thread(() -> {
           while (true){
               System.out.println(counter.getCount() + "by "+ Thread.currentThread().getName());
           }
        });

        Thread thread1 = new Thread(() -> {
            while (true){
                counter.increment();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });



        thread.start();
        thread1.start();

    }

    public static class Counter {
        private int count = 0;

        private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        private Lock readLock = reentrantReadWriteLock.readLock();
        private Lock writeLock = reentrantReadWriteLock.writeLock();

        public void increment() {
            writeLock.lock();
            try {
                count++;
            }finally {
                writeLock.unlock();
            }
        }

        public int getCount() {
            readLock.lock();
            try {
                return count;
            }finally {
                readLock.unlock();
            }
        }
    }
}
