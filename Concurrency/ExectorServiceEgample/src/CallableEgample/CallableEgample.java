package CallableEgample;
import java.util.concurrent.*;
import  java.util.*;

public class CallableEgample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> task = () -> {
            Thread.sleep(3000); // simulate long-running task
            return "Task completed by " + Thread.currentThread().getName();
        };

        Future<String> future = executor.submit(task);

        System.out.println("Task submitted. Waiting for it to finish...");

        // Check periodically if task is done
        while (!future.isDone()) {
            System.out.println("Still working...");
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){

            }
        }
        // Now task is complete
        try {
            // Now task is complete
            System.out.println("Done! Result: " + future.get());
        } catch (InterruptedException e) {
            System.out.println("Interrupted while waiting for result.");
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            System.out.println("Task threw an exception: " + e.getCause());
        }

        executor.shutdown();
    }
}


