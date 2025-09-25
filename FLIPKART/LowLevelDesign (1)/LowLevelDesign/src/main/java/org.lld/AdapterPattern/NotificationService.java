package main.java.org.lld.AdapterPattern;

public class NotificationService {

    public static void main(String[] args){
        NotificationInterface notification = new LegacyOnPremSMTPServer();
        notification.send("akshaykumar.942k@gmail.com","abc@gmail.com","Hello abc!");

        NotificationInterface notificationUsingSendgrid = new SendgridAdaptor(new SendgridEmail());
        notificationUsingSendgrid.send("akshaykumar.942k@gmail.com","abc@gmail.com","Hello abc!");
    }

}
