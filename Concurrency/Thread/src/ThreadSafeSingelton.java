public class ThreadSafeSingelton {

    private static volatile  ThreadSafeSingelton s;      // using volatile
    int a ;
    private ThreadSafeSingelton(int a){
        this.a = a;
    }

    public static ThreadSafeSingelton getInstance(int a){    // synchronised on "class" not "this".
        if(s==null){
            synchronized (ThreadSafeSingelton.class) {
                if (s == null) {
                    s = new ThreadSafeSingelton(a);
                }
            }
        }
        return s;
    }

    public int getA() {
        return a;
    }
}
