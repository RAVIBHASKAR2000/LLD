package basics.join;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactorialCalculation {
    public static void main(String[] args) throws InterruptedException {

        List<Long> inputNumbers = Arrays.asList(100000000L,3435L, 35435L, 2324L, 4656L, 23L, 5556L);

        List<FactorialThread> threads = new ArrayList<>();

        for (long inputNumber : inputNumbers) {
            threads.add(new FactorialThread(inputNumber));
        }

        for (Thread thread : threads) {
            //thread.setDaemon(true);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join(2000);
            thread.interrupt();
        }

        for (int i = 0; i < inputNumbers.size(); i++) {
            FactorialThread factorialThread = threads.get(i);
            if (factorialThread.isFinished()) {
                System.out.println("Factorial of " + inputNumbers.get(i) + " is " + factorialThread.getResult());
            } else {
                System.out.println("The calculation for " + inputNumbers.get(i) + " is still in progress");
            }
        }

    }

    public static class FactorialThread extends Thread{
        private long inputNumber;
        private BigInteger factorial = BigInteger.ZERO;
        private boolean isFinished = false;

        public FactorialThread(long inputNumber) {
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
                this.factorial = calculate(this.inputNumber);
                this.isFinished = true;


        }

        public BigInteger calculate(long inputNumber) {
            BigInteger tempResult = BigInteger.ONE;

            for(long i = inputNumber; i > 0; i--) {
                if(Thread.currentThread().isInterrupted()) {
                    return BigInteger.ZERO;
                }
                tempResult = tempResult.multiply(new BigInteger((Long.toString(i))));
            }

            return tempResult;
        }

        public BigInteger getResult() {
            return factorial;
        }

        public boolean isFinished() {
            return isFinished;
        }
    }
}
