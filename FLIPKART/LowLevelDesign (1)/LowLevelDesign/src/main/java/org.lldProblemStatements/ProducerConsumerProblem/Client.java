package main.java.org.lldProblemStatements.ProducerConsumerProblem;

import java.util.concurrent.*;

public class Client {
    private static final int QUEUE_SIZE = 10;
    private static BlockingQueue<Integer> q = new ArrayBlockingQueue<>(QUEUE_SIZE);
    private static int i = 1;

    public static class Producer implements Runnable{
        @Override
        public void run(){
            while(true) {

                try {
                    q.put(i++);
                    System.out.println("Produced val: " + (i - 1));
                    Thread.sleep(1000);

                } catch (Exception e) {
                    System.out.println("Something happened!");
                }
            }
        }
    }

    public static class Consumer implements Runnable{
        @Override
        public void run(){
            while(true) {
                try {
                    int val = q.take();
                    System.out.println("Consume val: " + (val));
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("Something happened!");
                }
            }
        }
    }

   public static void main(String[] args){
       Thread prodThread = new Thread(new Producer());
       Thread consThread = new Thread(new Consumer());

       prodThread.start();
       consThread.start();
   }
}
