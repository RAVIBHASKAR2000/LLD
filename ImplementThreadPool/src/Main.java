public class Main {
    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool(3);

        for (int i = 0; i < 10; i++) {
            final int taskId = i;

            Runnable r = new Runnable() {
                @Override
                public void run() {
                    System.out.println("Running Task " + taskId + " by " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignored) {

                    }
                }
            };
            pool.submit(r);
        }

        pool.shutdown();
    }
}