class Worker extends Thread {
    private final TaskQueue taskQueue;
    private volatile boolean isStopped = false;

    public Worker(TaskQueue taskQueue) {
        this.taskQueue = taskQueue;
    }

    public void run() {
        while (!isStopped) {
            try {
                Runnable task = taskQueue.dequeue();
                task.run();  // Execute the task
            } catch (InterruptedException e) {
                // Thread interrupted; exit gracefully
                break;
            }
        }
    }

    public void stopWorker() {
        isStopped = true;
        this.interrupt();  // Wake up if waiting
    }
}
