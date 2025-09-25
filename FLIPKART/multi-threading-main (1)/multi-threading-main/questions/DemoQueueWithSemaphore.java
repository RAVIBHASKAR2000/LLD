package questions;

import java.util.concurrent.Semaphore;

public class DemoQueueWithSemaphore {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueueSemaphore<Integer> queueSemaphore = new BlockingQueueSemaphore<>(5);

        Thread producer = new Thread(() -> {
           try {
               for (int i = 0; i < 50; i++) {
                   queueSemaphore.enqueue(Integer.valueOf(i));
                   //System.out.println(Thread.currentThread().getName() + "enqueued-" + i);
               }
           }catch (Exception e) {

           }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 50; i++) {
                    System.out.println(Thread.currentThread().getName() + "dequeued-" + queueSemaphore.dequeue());
                }
            }catch (Exception e) {

            }
        });

        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
    }
}

class BlockingQueueSemaphore<T> {
    T [] queue;
    int size;
    int capacity;
    int startIdx = 0;
    int endIdx = 0;
    Semaphore producerReady;
    Semaphore consumerReady;

    public BlockingQueueSemaphore(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
        consumerReady = new Semaphore(0);
        producerReady = new Semaphore(capacity);
    }

    public void enqueue(T element) throws InterruptedException {
        producerReady.acquire();

        if (endIdx == capacity) {
            endIdx = 0;
        }

        queue[endIdx] = element;
        endIdx++;
        size++;
        consumerReady.release();
    }

    public T dequeue() throws InterruptedException {
        consumerReady.acquire();

        if(startIdx == capacity) {
            startIdx = 0;
        }

        T item = queue[startIdx];
        startIdx++;
        size--;
        producerReady.release();

        return item;
    }
}
