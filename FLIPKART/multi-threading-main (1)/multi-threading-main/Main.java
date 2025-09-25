public class Main {
    public static void main(String[] args) throws InterruptedException {
        InventoryCounter inventoryCounter = new InventoryCounter();
        IncrementingThread incrementingThread = new IncrementingThread(inventoryCounter);
        DecrementingThread decrementingThread = new DecrementingThread(inventoryCounter);
        DecrementingThread decrementingThread2 = new DecrementingThread(inventoryCounter);

        incrementingThread.start();
        decrementingThread.start();
        decrementingThread2.start();
        decrementingThread.setPriority(Thread.MIN_PRIORITY);
        decrementingThread2.setPriority(Thread.MAX_PRIORITY);

        incrementingThread.join();
        decrementingThread.join();
        decrementingThread2.join();

        System.out.println("We currently have " + inventoryCounter.getItems() + " items");
    }

    public static class DecrementingThread extends Thread {

        private InventoryCounter inventoryCounter;

        public DecrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    inventoryCounter.decrement();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static class IncrementingThread extends Thread {

        private InventoryCounter inventoryCounter;

        public IncrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                inventoryCounter.increment();
            }
        }
    }

    private static class InventoryCounter {
        private int items = 0;
        private volatile boolean readyForDecrementing = false;

        public synchronized void increment() {
            items++;
            if(items == 10)
            {readyForDecrementing = true;
            notify();
            }

        }

        public synchronized void decrement() throws InterruptedException {

            while (!readyForDecrementing){
                System.out.println(Thread.currentThread().getName() + " waiting for decrement");
                this.wait();

            }
            System.out.println(Thread.currentThread().getName() + " decrement");
            items--;
            if(items == 0)
                notify();

        }

        public int getItems() {
            return items;
        }
    }
}
