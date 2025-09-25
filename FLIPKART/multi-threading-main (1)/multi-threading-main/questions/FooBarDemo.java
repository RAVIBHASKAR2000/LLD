package questions;

public class FooBarDemo {
    public static void main(String[] args) throws InterruptedException {
        PrintFooBar printFooBar = new PrintFooBar();
        Thread foo = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    printFooBar.printFoo();
                }
            }catch (Exception e) {}

        });

        Thread bar = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    printFooBar.printBar();
                }
            }catch (Exception e) {}
        });

        Thread comma = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    printFooBar.printComma();
                }
            }catch (Exception e) {}
        });

        foo.start();
        bar.start();
        comma.start();

        foo.join();
        bar.join();
        comma.join();
    }
}

class PrintFooBar{

    int state = 0;

    public void printFoo() throws InterruptedException {

        synchronized(this){

            while (state != 0) {
                this.wait();
            }

            System.out.print("Foo");
            state = 1;
            this.notifyAll();
        }


    }

    public void printBar() throws InterruptedException {
        synchronized(this){
            while (state != 2){
                this.wait();
            }

            System.out.print("Bar");
            state = 0;
            this.notifyAll();
        }

    }

    public void printComma() throws InterruptedException {
        synchronized (this){
            while (state != 1){
                this.wait();
            }

            System.out.print(",");
            //readyForComma = false;
            this.notifyAll();
        }
    }

}
