package basics.interruption;

import java.math.BigInteger;

public class LongComputation {
    public static void main(String[] args) {

        Thread thread = new Thread(new LongTask(new BigInteger("200000"), new BigInteger("100000000")));
        thread.start();
        thread.interrupt();

    }

    private static class LongTask extends Thread{
        private BigInteger base;
        private BigInteger power;

        public LongTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                if(Thread.currentThread().isInterrupted()) {
                    return BigInteger.ZERO;
                }
                result = result.multiply(base);
            }

            return result;
        }

    }
}
