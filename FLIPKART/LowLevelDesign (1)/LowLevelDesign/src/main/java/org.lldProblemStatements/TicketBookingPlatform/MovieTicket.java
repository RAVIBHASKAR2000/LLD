package main.java.org.lldProblemStatements.TicketBookingPlatform;

public class MovieTicket implements Ticket{
    private Event event;
    private User ticketOwner;
    private Seats seat;
    private Auditorium auditorium;

    public MovieTicket(Event event, User ticketOwner, Seats seat, Auditorium auditorium){
        this.event = event;
        this.ticketOwner = ticketOwner;
        this.seat = seat;
        this.auditorium = auditorium;
    }

    public Event getEvent(String eventName){
        return this.event;
    }

    public Event getEvent() {
        return event;
    }

    public User getTicketOwner() {
        return ticketOwner;
    }
}
