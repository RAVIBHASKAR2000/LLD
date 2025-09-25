package questions;

public class DemoQueue {
    public static void main(String[] args) throws InterruptedException {
        testGenericQueue();
//        final BlockingQueueSimple blockingQueueSimple = new BlockingQueueSimple(5);
//
//        Thread t1 = new Thread(() -> {
//            try {
//                for (int i = 0; i < 50; i++) {
//                    blockingQueueSimple.enqueue(i);
//                    System.out.println("enqueued " + i);
//                }
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//
//        Thread t2 = new Thread(() -> {
//            try {
//                for (int i = 0; i < 25; i++) {
//                    int ans = blockingQueueSimple.dequeue();
//                    System.out.println("dequeued " + ans);
//                }
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//        Thread t3 = new Thread(() -> {
//            try {
//                for (int i = 0; i < 25; i++) {
//                    int ans = blockingQueueSimple.dequeue();
//                    System.out.println("dequeued " + ans);
//                }
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//        t1.start();
//        t2.start();
//        t3.start();
//
//        t2.join();
//        t1.join();
//        t3.join();
    }

    public static void testGenericQueue() throws InterruptedException {
        final BlockingQueueGeneric<Integer> blockingQueueGeneric = new BlockingQueueGeneric<>(5);

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 50; i++) {
                    blockingQueueGeneric.enqueue(Integer.valueOf(i));
                    System.out.println("enqueued " + i);
                }
            }catch (InterruptedException e) {

            }

        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 50; i++) {
                    System.out.println("Thread 2 dequeued: " + blockingQueueGeneric.dequeue());
                }
            }catch (InterruptedException e) {

            }

        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

class BlockingQueueSimple{
    int [] arr;
    int capacity;
    int size = 0;
    Object lock = new Object();
    int endIdx= 0;
    int startIdx = 0;


    public BlockingQueueSimple(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public void enqueue(int data) throws InterruptedException {
        synchronized (lock) {
            while (size == capacity) {
                lock.wait();
            }

            if (endIdx == capacity) {
                endIdx = 0;
            }

            arr[endIdx] = data;
            endIdx++;
            size++;
            lock.notifyAll();
        }
    }

    public int dequeue() throws InterruptedException {
        int data;
        synchronized (lock) {
            while (size == 0) {
                lock.wait();
            }

            if (startIdx == capacity) {
                startIdx = 0;
            }

            data = arr[startIdx];
            startIdx++;
            size--;
            lock.notifyAll();

        }

        return data;
    }
}


class BlockingQueueGeneric<T>{
    T[] array;
    int capacity;
    int size = 0;
    int endIdx= 0;
    int startIdx= 0;
    Object lock = new Object();

    public BlockingQueueGeneric(int capacity){
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public void enqueue(T data) throws InterruptedException {
        synchronized (lock){
            while (size == capacity) {
                lock.wait();
            }

            if (endIdx == capacity) {
                endIdx = 0;
            }

            array[endIdx] = data;
            endIdx++;
            size++;
            lock.notifyAll();
        }
    }

    public T dequeue() throws InterruptedException {
        T data;
        synchronized (lock){
            if(size == 0){
                lock.wait();
            }

            if (startIdx == capacity) {
                startIdx = 0;
            }

            data = array[startIdx];
            array[startIdx] = null;
            startIdx++;
            size--;
            lock.notifyAll();
        }

        return data;
    }
}