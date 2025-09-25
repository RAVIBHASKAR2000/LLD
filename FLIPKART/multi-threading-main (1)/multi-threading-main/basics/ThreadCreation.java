package basics;

public class ThreadCreation {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("inside thread 1");
            throw new RuntimeException("Exception in thread 1");
        });

        t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Exception in thread " + t + " " + e);
            }
        });

        t1.setPriority(Thread.MAX_PRIORITY);
        System.out.println("before starting thread 1");
        t1.start();
        System.out.println("after starting thread 1");
    }
}
