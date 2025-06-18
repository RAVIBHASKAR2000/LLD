//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


//        ThreadSafeSingeltonClass s =  ThreadSafeSingeltonClass.getInstance(10);
//        ThreadSafeSingeltonClass s1 =  ThreadSafeSingeltonClass.getInstance(5);
//
//        System.out.println(s.getA());
//        System.out.println(s1.getA());

        /*

        simualting RACE conditiion
         */

        System.out.println("Thread NOt safe diffrent hashCode");
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread NOt safe diffrent hashCode");
                ThreadNotSafeSingeltonClass s =  ThreadNotSafeSingeltonClass.getInstance(10);
                System.out.println(s.hashCode());
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread NOt safe diffrent hashCode");
                ThreadNotSafeSingeltonClass s =  ThreadNotSafeSingeltonClass.getInstance(12);
                System.out.println(s.hashCode());
            }
        };


        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        /*
        simulating thread safe conditons
         */

        System.out.println("Thread  safe same hashCode");


        Runnable r3 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread  safe same hashCode");
                ThreadSafeSingelton s =  ThreadSafeSingelton.getInstance(10);
                System.out.println(s.hashCode());
            }
        };
        Runnable r4 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread  safe same hashCode");
                ThreadSafeSingelton s =  ThreadSafeSingelton.getInstance(12);
                System.out.println(s.hashCode());
            }
        };


        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);

        t3.start();
        t4.start();

    }
}