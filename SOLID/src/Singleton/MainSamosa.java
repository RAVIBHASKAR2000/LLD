package Singleton;

public class MainSamosa {
    public static  void main(String[] args){
        System.out.println("SIngelton main");

        Samosa s = Samosa.getSamosa();

        s.printSamosa();
    }
}
