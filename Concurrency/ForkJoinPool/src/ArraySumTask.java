import java.util.concurrent.*;

class ArraySumTask extends RecursiveTask<Long> {
    private final int[] arr;
    private final int start, end;

    private static final int THRESHOLD = 3;

    public ArraySumTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            // Small enough to compute directly
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            return sum;
        } else {
            // Split into two tasks
            int mid = (start + end) / 2;
            ArraySumTask leftTask = new ArraySumTask(arr, start, mid);
            ArraySumTask rightTask = new ArraySumTask(arr, mid, end);

            leftTask.fork();               // async execution
            long rightResult = rightTask.compute();  // compute right now
            long leftResult = leftTask.join();       // wait for left

            return leftResult + rightResult;
        }
    }
}
