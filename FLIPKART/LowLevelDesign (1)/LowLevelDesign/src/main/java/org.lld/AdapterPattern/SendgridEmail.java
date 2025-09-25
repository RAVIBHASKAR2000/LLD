package main.java.org.lld.AdapterPattern;

public class SendgridEmail {
    public void sendEmail(String toAddress, String fromAddress, String body){
        System.out.println("Sending email notification using sendgrid from user: "+fromAddress);
        System.out.println("Sending email notification using sendgrid to user: "+toAddress);
        System.out.println("Sending email notification using sendgrid with body: "+body);
    }
}
