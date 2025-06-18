package ReentrantLock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        // Thread 1: grabs the lock and sleeps
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread-1 got the lock.");
                Thread.sleep(3000); // simulate long task
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("Thread-1 released the lock.");
            }
        });

        // Thread 2: tries to get the lock but won't wait
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(100); // wait a bit so Thread-1 acquires lock first
                if (lock.tryLock()) {  // try to acquire without blocking
                    try {
                        System.out.println("Thread-2 got the lock.");
                    } finally {
                        lock.unlock();
                        System.out.println("Thread-2 released the lock.");
                    }
                } else {
                    System.out.println("Thread-2 couldn't get the lock and won't wait.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}
