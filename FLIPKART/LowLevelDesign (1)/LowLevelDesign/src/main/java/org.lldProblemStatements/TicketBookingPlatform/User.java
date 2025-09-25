package main.java.org.lldProblemStatements.TicketBookingPlatform;

public interface User {
    Ticket searchActiveTicket(String eventName);
    Ticket searchPastTicket(String eventName);
    void addEventTicket(Ticket ticket);
    void markEventOver(Ticket ticket);
}
