package main.java.org.lld.AdapterPattern;

public class SendgridAdaptor implements NotificationInterface{

    private SendgridEmail sendgrid;

    public SendgridAdaptor(SendgridEmail sendgrid){
        this.sendgrid = sendgrid;
    }

    public void send(String username, String toAddress, String body){
        this.sendgrid.sendEmail(toAddress,username,body);
    }
}
