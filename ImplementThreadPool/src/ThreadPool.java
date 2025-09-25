import  java.util.*;


class ThreadPool {
    private final List<Worker> workers = new ArrayList<>();
    private final TaskQueue taskQueue = new TaskQueue();

    public ThreadPool(int numThreads) {
        for (int i = 0; i < numThreads; i++) {
            Worker worker = new Worker(taskQueue);
            worker.start();
            workers.add(worker);
        }
    }

    public void submit(Runnable task) {
        taskQueue.enqueue(task);
    }

    public void shutdown() {
        for (Worker worker : workers) {
            worker.stopWorker();
        }
    }
}
