package main.java.org.lldProblemStatements.TicketBookingPlatform;

import java.util.HashMap;

public interface Auditorium {
    HashMap<String,Event> getEventSchedule();
    Event getEventAt(String time);
    int getNumberOfAvailableSeats();
    Event getCurrentEvent();
    void startEvent(Event event);
    void addEvent(String time,Event event);
    Seats bookNormalSeat(int seatNumber);
}
