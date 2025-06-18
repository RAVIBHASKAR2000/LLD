package ListOfThread;


import  java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        // Create 5 threads that print numbers
        for (int i = 1; i <= 5; i++) {
            int threadNum = i;
            Thread t = new Thread(() -> {
                System.out.println("Thread " + threadNum + " started.");
                try {
                    Thread.sleep(1000 * threadNum);  // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread " + threadNum + " finished.");
            });
            threads.add(t);
        }

        // Start all threads
        for (Thread t : threads) {
            t.start();
        }

        // Wait for all threads to complete
        for (Thread t : threads) {
            try {
                t.join();  // Wait for this thread to finish
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All threads have completed!");

    }
}