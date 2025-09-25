package questions;

public class NumberSeriesDemoLock {
    public static void main(String[] args) throws InterruptedException {
        NumberSeriesLock numberSeriesLock = new NumberSeriesLock(10);

        Thread zeroT = new Thread(() -> {
            try {
                numberSeriesLock.printZero();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread oddT = new Thread(() -> {
            try {
                numberSeriesLock.printOdd();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread evenT = new Thread(() -> {
            try {
                numberSeriesLock.printEven();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        zeroT.start();
        oddT.start();
        evenT.start();
        zeroT.join();
        oddT.join();
        evenT.join();
    }

}

class NumberSeriesLock {
    int n;
    int state = 0;

    public NumberSeriesLock(int n) {
        this.n = n;
    }

    public void printZero() throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (state !=0 ) {
                    this.wait();
                }
                System.out.print(0);
                state = (i%2 ==0)?1:2;
                this.notifyAll();
            }
        }
    }

    public void printOdd() throws InterruptedException {

        for (int i = 1; i <= n; i+=2) {
            synchronized (this) {
                while (state !=1 ) {
                    this.wait();
                }
                System.out.print(i);
                state = 0;
                this.notifyAll();
            }
        }
    }

    public void printEven() throws InterruptedException {

        for (int i = 2; i <= n; i+=2) {
            synchronized (this) {
                while (state !=2 ) {
                    this.wait();
                }
                System.out.print(i);
                state = 0;
                this.notifyAll();
            }
        }
    }
}
