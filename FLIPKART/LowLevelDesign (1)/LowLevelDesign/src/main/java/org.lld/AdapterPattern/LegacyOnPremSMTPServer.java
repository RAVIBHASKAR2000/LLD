package main.java.org.lld.AdapterPattern;

public class LegacyOnPremSMTPServer implements NotificationInterface{

    @Override
    public void send(String username, String toAddress, String body) {
        System.out.println("Sending email notification from user: "+username);
        System.out.println("Sending email notification to user: "+toAddress);
        System.out.println("Sending email notification with body: "+body);
    }
}
