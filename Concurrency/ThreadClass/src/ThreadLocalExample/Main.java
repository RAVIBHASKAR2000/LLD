package ThreadLocalExample;
public class Main {
    // Each thread gets its own copy of threadId
    private static ThreadLocal<Integer> threadId = new ThreadLocal<>();

    public static void main(String[] args) {
        Runnable task = () -> {
            int id = (int) (Math.random() * 1000);
            threadId.set(id);  // Set a thread-specific value

            System.out.println(Thread.currentThread().getName() + " has thread-local ID: " + threadId.get());

            // Optional: remove to prevent memory leak in long-lived threads
            threadId.remove();
        };

        // Create and start 3 threads
        for (int i = 1; i <= 3; i++) {
            new Thread(task, "Worker-" + i).start();
        }
    }
}