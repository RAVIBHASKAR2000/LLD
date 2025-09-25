package main.java.org.lldProblemStatements.RideSharingApp;

public class SendGrid implements EmailClient {
    private String apiKey;
    private String accountID;

    public SendGrid(String apiKey, String accountID){
        this.apiKey = apiKey;
        this.accountID = accountID;
    }

    @Override
    public void sendEmail(String to, String from, String body) {
        System.out.printf("Notifying user %s : %s", to, body);
    }
}
