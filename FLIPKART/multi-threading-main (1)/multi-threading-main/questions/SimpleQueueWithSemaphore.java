package questions;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Semaphore;


public class SimpleQueueWithSemaphore {
    private static final Integer QUEUE_SIZE = 5;
    private static final int MAX_COUNT = 50;

    public static void main(String[] args) {
        QueueOperation queueOperation = new QueueOperation();
        Random random = new Random();

        Thread producer1 = new Thread(() -> {
            try {
                for (int i = 0; i < MAX_COUNT; i++) {
                    queueOperation.enqueue(i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread producer2 = new Thread(() -> {
            try {
                for (int i = 0; i < MAX_COUNT; i++) {
                    queueOperation.enqueue(i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer1 = new Thread(() -> {
            try {
                for (int i = 0; i < MAX_COUNT; i++) {
                    queueOperation.dequeue();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer2 = new Thread(() -> {
            try {
                for (int i = 0; i < MAX_COUNT; i++) {
                    queueOperation.dequeue();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();

    }

    public static class QueueOperation {
        Queue<Integer> queue = new ArrayDeque<>(QUEUE_SIZE);
        Semaphore full = new Semaphore(0);
        Semaphore empty = new Semaphore(QUEUE_SIZE);
        Object lock = new Object();

        public void enqueue(int item) throws InterruptedException {
            empty.acquire();
            synchronized (lock) {
                queue.add(item);
            }
            full.release();
        }

        public int dequeue() throws InterruptedException {
            full.acquire();
            int item;
            synchronized (lock) {
                item = queue.remove();
                System.out.println(item + " dequeued by " + Thread.currentThread().getName());
            }
            empty.release();  // Signal that a space is available
            return item;
        }
    }
}
