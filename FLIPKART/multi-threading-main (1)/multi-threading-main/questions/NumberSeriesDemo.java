package questions;

import java.util.concurrent.Semaphore;

public class NumberSeriesDemo {
    public static void main(String[] args) throws InterruptedException {
        NumberSeries numberSeries = new NumberSeries(10);
        Thread zeroT = new Thread(() -> {
            numberSeries.PrintZero();
        });

        Thread oddT = new Thread(() -> {
            numberSeries.PrintOdd();
        });

        Thread evenT = new Thread(() -> {
            numberSeries.PrintEven();
        });

        zeroT.start();
        oddT.start();
        evenT.start();
        zeroT.join();
        oddT.join();
        evenT.join();
    }
}

class NumberSeries {
    private int n;
    private Semaphore zeroSem, oddSem, evenSem;

    public NumberSeries(int n) {
        this.n = n;
        zeroSem = new Semaphore(1);
        oddSem = new Semaphore(0);
        evenSem = new Semaphore(0);
    }

    public void PrintZero(){
        for (int i = 0; i < n; i++) {
            try {
                zeroSem.acquire();
            } catch (InterruptedException e) {

            }
            System.out.print(0);

            if(i %2 == 0)
                oddSem.release();
            else{
                evenSem.release();
            }
        }
    }


    public void PrintOdd(){
        for (int i = 1; i <= n; i+=2) {
            try {
                oddSem.acquire();
            } catch (InterruptedException e) {

            }
            System.out.print(i);
            zeroSem.release();
        }
    }


    public void PrintEven(){
        for (int i = 2; i <= n; i+=2) {
            try {
                evenSem.acquire();
            } catch (InterruptedException e) {

            }
            System.out.print(i);
            zeroSem.release();
        }
    }
}
