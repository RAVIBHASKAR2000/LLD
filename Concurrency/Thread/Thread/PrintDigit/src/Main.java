import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
               for(int i=0;i<100;i++){
                   if(i%2==0){
                       System.out.println(i + "thread1");
                   }
               }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    if(i%2!=0){
                        System.out.println(i + "thread2");
                    }
                }
            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}