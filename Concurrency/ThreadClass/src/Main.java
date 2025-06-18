
class myRunnable implements Runnable {

    int a;
    myRunnable(int a){
        this.a =a;
    }

    @Override
    public void run() {
        if(a%2==0){
            System.out.println("EvEn "+ a);
            System.out.println(Thread.currentThread().getName());
        }
        else{
            System.out.println("Odd "+a);
            System.out.println(Thread.currentThread().getName());
        }
    }
}
public class Main {
    public static void main(String[] args) {



        for(int i=0;i<10;i++){
            Runnable r1 = new myRunnable(i);
            Thread t1 = new Thread(r1);
            t1.start();
        }



    }
}