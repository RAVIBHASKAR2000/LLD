

import  java.util.concurrent.*;

public class ForkJoinClass {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};

        ForkJoinPool pool = new ForkJoinPool(); // uses available cores
        ArraySumTask task = new ArraySumTask(nums, 0, nums.length);

        long result = pool.invoke(task);
        System.out.println("Sum: " + result);
    }
}
