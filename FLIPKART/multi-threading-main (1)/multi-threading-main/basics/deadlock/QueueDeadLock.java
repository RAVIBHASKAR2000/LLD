package basics.deadlock;

import java.util.ArrayDeque;
import java.util.Random;

public class QueueDeadLock {

    public static void main(String[] args) {

        QueueDemo queueDemo = new QueueDemo();

        Thread t1 = new Thread(() -> {
            while (true) {
                Random random = new Random();
                try {
                    Thread.sleep(random.nextInt(5));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                queueDemo.enqueue(random.nextInt(10));
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                Random random = new Random();
                try {
                    Thread.sleep(random.nextInt(5));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                queueDemo.dequeue();
            }
        });

        t1.start();
        t2.start();
    }

    public static class QueueDemo {
        private ArrayDeque<Integer> mainQueue = new ArrayDeque<>();
        private ArrayDeque<Integer> blockingQueue = new ArrayDeque<>();

        public void enqueue(int x) {
            synchronized (mainQueue) {
                System.out.println(Thread.currentThread().getName() + " enqueued in Main" + x);
                mainQueue.offer(x);
                synchronized (blockingQueue) {
                    System.out.println(Thread.currentThread().getName() + " enqueued in Blocking" + x);
                    blockingQueue.offer(x);
                }
            }
        }

        public void dequeue() {
            synchronized (mainQueue) {
                System.out.println(Thread.currentThread().getName() + " dequeued in Main");
                mainQueue.poll();
                synchronized (blockingQueue) {
                    System.out.println(Thread.currentThread().getName() + " dequeued in Blocking");
                    blockingQueue.poll();
                }
            }
        }
    }
}
