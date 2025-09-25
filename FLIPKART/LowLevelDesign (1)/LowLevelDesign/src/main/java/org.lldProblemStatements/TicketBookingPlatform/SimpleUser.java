package main.java.org.lldProblemStatements.TicketBookingPlatform;

import java.util.*;

public class SimpleUser implements User {

    private String username;
    private String name;
    private String phoneNumber;
    private List<Ticket> upcomingTickets;
    private List<Ticket> pastTickets;


    public SimpleUser(String username, String name, String phoneNumber) {
        this.username = username;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.upcomingTickets = new ArrayList<>();
        this.pastTickets = new ArrayList<>();
    }

    @Override
    public Ticket searchActiveTicket(String eventName) {
        // logic to search tickets
        return upcomingTickets.get(0);
    }

    @Override
    public Ticket searchPastTicket(String eventName) {
        // logic to search tickets
        return pastTickets.get(0);
    }

    public void addEventTicket(Ticket ticket){
        upcomingTickets.add(ticket);
    }

    public void markEventOver(Ticket ticket){
        upcomingTickets.remove(ticket);
        pastTickets.add(ticket);
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
