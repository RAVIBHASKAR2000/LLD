package main.java.org.lldProblemStatements.TicketBookingPlatform;

public class Client {
    public static void main(String[] args){
        // initialise a user
        User user = new SimpleUser("ak6_kumar","Akshay", "8008280284");

        // initialize a theater
        Theater pvrPheonix  = new Theater(3,"PVR Pheonix Mall WhiteField");

        // create movies
        Auditorium audi2 = pvrPheonix.getAuditorium(2);
        audi2.addEvent("2:00 PM",new MovieEvent("2:00 PM", 3,"Inception"));
        String movieName = "Inception";

        BookingService bookingService = new BookingService();
        Ticket ticket = bookingService.createBooking(pvrPheonix,"2:00 PM",movieName,"Normal", user);


    }
}
