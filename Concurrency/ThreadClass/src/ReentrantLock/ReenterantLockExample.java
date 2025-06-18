package ReentrantLock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterantLockExample {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Runnable task = () -> {
            lock.lock(); // acquire the lock
            try {
                System.out.println(Thread.currentThread().getName() + " got the lock.");
                Thread.sleep(1000); // simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock(); // must release the lock
                System.out.println(Thread.currentThread().getName() + " released the lock.");
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }

}
