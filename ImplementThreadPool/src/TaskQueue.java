import  java.util.*;

class TaskQueue {
    private final Queue<Runnable> queue = new LinkedList<>();

    public synchronized void enqueue(Runnable task) {
        queue.offer(task);
        notify(); // Wake up one waiting worker
    }

    public synchronized Runnable dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();  // Block until task is available
        }
        return queue.poll();
    }
}
