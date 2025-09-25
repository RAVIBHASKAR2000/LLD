package questions;

public class OrderedPrintingDemo {
    public static void main(String[] args) throws InterruptedException {
        OrderedPrinting orderedPrinting = new OrderedPrinting();
        Thread t1 = new Thread(() -> {
            try {
                orderedPrinting.print1();
            }catch (Exception e) {

            }
        });

        Thread t2 = new Thread(() -> {
            try {
                orderedPrinting.print2();
            }catch (Exception e) {

            }
        });

        Thread t3 = new Thread(() -> {
            try {
                orderedPrinting.print3();
            }catch (Exception e) {

            }
        });


        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

    }
}

class OrderedPrinting{

    int count;

    public OrderedPrinting(){
        count = 1;
    }

    public void print1(){
        synchronized(this){
            System.out.println("print1");
            count++;
            this.notifyAll();
        }

    }

    public void print2() throws InterruptedException {
        synchronized(this){
            while (count != 2){
                this.wait();
            }

            System.out.println("print2");
            count++;
            this.notifyAll();
        }

    }

    public void print3() throws InterruptedException {
        synchronized(this){
            while (count != 3){
                this.wait();
            }

            System.out.println("print3");
            count++;
            this.notifyAll();
        }
    }
}
