package questions;

import java.util.concurrent.locks.ReentrantLock;

public class NumberWithReetrant {
    private static ReentrantLock lock = new ReentrantLock();
    private static boolean readyForComma = false;
    private static final int MAX_RANGE = 50;
    private static int count = 1;

    public static void main(String[] args) {

        Thread number = new Thread(() -> {


            while (count <= MAX_RANGE) {
                if (lock.tryLock()) {
                    try {
                        if (!readyForComma && count <= MAX_RANGE) {
                            System.out.print(count);
                            count++;
                            readyForComma = true;
                        }
                    } finally {
                        lock.unlock();
                    }

                }


            }
        });

        Thread comma = new Thread(() -> {


            while (count <= MAX_RANGE ) {

                if (lock.tryLock()) {
                    try {
                        if (readyForComma && count <= MAX_RANGE ) {
                            System.out.print(",");
                            readyForComma = false;
                        }
                    } finally {
                        lock.unlock();
                    }

                }

            }
        });


        number.start();
        comma.start();
    }
}