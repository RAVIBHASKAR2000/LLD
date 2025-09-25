package main.java.org.lld.SingletonPattern;

public class AppHandler {

    public static void main(String[] args){
        AppConfiguration appConfig1 = AppConfiguration.getInstance();
        AppConfiguration appConfig2 = AppConfiguration.getInstance();

        System.out.println(appConfig1==appConfig2);
    }

}
