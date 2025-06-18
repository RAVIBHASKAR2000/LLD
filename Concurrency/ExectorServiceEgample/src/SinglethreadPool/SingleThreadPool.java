package SinglethreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " is executing task");
            try {
                Thread.sleep(1000); // simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " finished task");
        };

        // Submit 5 tasks to executor
        for (int i = 0; i < 5; i++) {
            executor.submit(task);
        }

        // Gracefully shutdown the executor
        executor.shutdown();
    }
}
