package main.java.org.lldProblemStatements.RideSharingApp;

public class NotifyTripUpdatesUsers {
    private static EmailClient sendgrid = new SendGrid("api-key","accountId");
    private static String toAddress = "no-reply@akshay-ride-sharing-app.com";
    public static void notifyUser(User user, String body) {
        sendgrid.sendEmail(user.getEmail(), toAddress, body);
    }
}
