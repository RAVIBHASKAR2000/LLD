package basics.unsafe;

import java.util.Random;

public class ThreadUnsafeOperation {
    static Random random = new Random(System.currentTimeMillis());
    public static void main(String[] args) throws InterruptedException{
        ThreadUnsafeCounter badCounter = new ThreadUnsafeCounter();

        Thread thread1 = new Thread(() ->{
            badCounter.increment();
            ThreadUnsafeOperation.sleepRandomlyForLessThan10Secs();
        });

        Thread thread2 = new Thread(() ->{
            badCounter.decrement();
            ThreadUnsafeOperation.sleepRandomlyForLessThan10Secs();
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        badCounter.printCounter();
    }

    public static void sleepRandomlyForLessThan10Secs() {
        try {
            Thread.sleep(random.nextInt(10));
        } catch (InterruptedException ie) {
        }
    }

    public static class ThreadUnsafeCounter {
        int count = 0;

        public void increment() {
            count++;
        }

        public void decrement() {
            count--;
        }

        void printCounter() {
            System.out.println(count);
        }
    }
}
