public class ThreadNotSafeSingeltonClass {

    private static ThreadNotSafeSingeltonClass s;
    int a ;
    private ThreadNotSafeSingeltonClass(int a){
        this.a = a;
    }

    public static ThreadNotSafeSingeltonClass getInstance(int a){
        if(s==null){
            try {
                Thread.sleep(5000); // Artificial delay to simulate race condition
            } catch (InterruptedException e) {

            }
            s = new ThreadNotSafeSingeltonClass(a);

            return s;
        }
        return s;
    }

    public int getA() {
        return a;
    }
}
