package questions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RecursiveTask;

public class NumberWithLock {
    private static Object lock = new Object();
    private static final int MAX_RANGE = 50;
    private static int count = 1;
    private static boolean readyForComma = false;

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(3);

        for(int i = 0 ; i < MAX_RANGE ; i++) {
            service.execute(() -> {

            });
        }

        Thread number = new Thread(() -> {
            while (count <= MAX_RANGE) {
                synchronized (lock) {
                    if (!readyForComma) {
                        System.out.print(count);
                        count++;
                        readyForComma = true;
                    }
                }
            }
        });

        Thread comma = new Thread(() -> {
            while (count <= MAX_RANGE) {
                synchronized (lock) {
                    if (readyForComma) {

                        if(count <= MAX_RANGE) {
                            System.out.print(",");
                        }

                        readyForComma = false;
                    }
                }
            }
        });

        number.start();
        comma.start();

    }
}
