public class Main {
    public  static  class Resource {}

    private final static Resource ResourceA = new Resource();
    private  final  static  Resource ResourceB = new Resource();

    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                synchronized (ResourceA){
                    System.out.println("Thread 1: locked Resource A");

                    try{
                        Thread.sleep(1000);

                    }
                    catch (InterruptedException e){

                    }

                    synchronized (ResourceB){
                        System.out.println("Thread 1 : locked resource B");
                    }
                }
            }
        };

        Runnable r2= new Runnable() {
            @Override
            public void run() {
                synchronized (ResourceB){
                    System.out.println("Thread 2 : Locked resouce B");


                    try{
                        Thread.sleep(1000);

                    }
                    catch (InterruptedException e){

                    }

                    synchronized (ResourceA){
                        System.out.println("Thread 2: locked Resource A");
                    }
                }

            }
        };
        Thread T1 = new Thread(r1);

        Thread T2 = new Thread(r2);

        T1.start();
        T2.start();
    }
}