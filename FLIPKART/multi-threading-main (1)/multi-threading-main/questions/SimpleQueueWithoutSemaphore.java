package questions;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class SimpleQueueWithoutSemaphore {
    private static final Integer QUEUE_SIZE = 5;
    private static final int MAX_COUNT = 1000;

    public static void main(String[] args) {
        QueueOperation queueOperation = new QueueOperation();
        Random random = new Random();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < MAX_COUNT; i++) {
                    queueOperation.enqueue(random.nextInt(1000));
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread producer1 = new Thread(() -> {
            try {
                for (int i = 0; i < MAX_COUNT; i++) {
                    queueOperation.enqueue(random.nextInt(1000));
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        Thread consumer = new Thread(() -> {
            try {

                for (int i = 0; i < MAX_COUNT; i++) {
                    queueOperation.dequeue();
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer1 = new Thread(() -> {
            try {

                for (int i = 0; i < MAX_COUNT; i++) {
                    queueOperation.dequeue();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        consumer.setPriority(Thread.MAX_PRIORITY);


        producer.start();
        //producer1.start();
        consumer.start();

        try {
            //producer1.join();
            producer.join();
            consumer.join();
            //consumer2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
//        consumer1.start();
    }

    public static class QueueOperation {
        Queue<Integer> queue = new ArrayDeque<>(QUEUE_SIZE);
        Object lock = new Object();

        public void enqueue(int item) throws InterruptedException {
            synchronized (lock) {
                while (queue.size() >= QUEUE_SIZE) {
                    lock.wait();
                }
                System.out.println(item + " enqueued " + Thread.currentThread().getName());
                queue.add(item);
                lock.notifyAll();
            }
        }

        public int dequeue() throws InterruptedException {
            synchronized (lock) {
                while (queue.isEmpty()) {
                    lock.wait();
                }
                try {

                    System.out.println("dequeued " + Thread.currentThread().getName());
                    return queue.remove();
                } finally {
                    lock.notifyAll();
                }
            }
        }
    }
}
