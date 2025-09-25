package basics.interruption;

public class InterruptException {
    public static void main(String[] args) {
        Thread thread = new Thread(new BlockingThread());

        thread.start();
        thread.interrupt();

    }

    public static class BlockingThread implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(500000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}
