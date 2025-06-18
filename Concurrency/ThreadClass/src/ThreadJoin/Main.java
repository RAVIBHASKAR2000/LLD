package Concurrency.ThreadClass.src.ThreadJoin;

class WorkerThread extends Thread {
    private String name;

    public WorkerThread(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(name + " started.");
        try {
            Thread.sleep(2000);  // Simulate long task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " finished.");
    }
}

public class Main {
    public static void main(String[] args) {
        WorkerThread t1 = new WorkerThread("Thread-1");
        WorkerThread t2 = new WorkerThread("Thread-2");

        t1.start();
        t2.start();

        try {
            // Wait for t1 and t2 to finish
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread ends after both threads complete.");
    }
}