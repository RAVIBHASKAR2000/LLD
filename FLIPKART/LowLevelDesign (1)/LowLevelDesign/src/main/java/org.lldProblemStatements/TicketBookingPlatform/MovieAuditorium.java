package main.java.org.lldProblemStatements.TicketBookingPlatform;

import java.util.*;

public class MovieAuditorium implements Auditorium {
    private HashMap<String,Event> upcomingEventScheduleMap;
    private List<Seats> seats;
    private Event currentRunningEvent;
    private int totalNormalSeat = 10;
    private int totalPremiumSeat = 10;
    private int numberOfAvailableNormalSeats;
    private int numberOfAvailablePremiumSeats;

    public MovieAuditorium(int numberOfNormalSeats, int numberOfPremiumSeats){
        this.numberOfAvailableNormalSeats = numberOfNormalSeats;
        int i=1;
        for(;i<=numberOfNormalSeats;i++){
            seats.add(new NormalSeats(String.valueOf(i)));
        }

        this.numberOfAvailablePremiumSeats = numberOfPremiumSeats;
        for(;i<=numberOfNormalSeats+numberOfPremiumSeats;i++){
            seats.add(new PremiumSeats(String.valueOf(i)));
        }
        upcomingEventScheduleMap = new HashMap<>();
    }

    @Override
    public HashMap<String, Event> getEventSchedule() {
        return this.upcomingEventScheduleMap;
    }

    public void addEvent(String time,Event event){
        this.upcomingEventScheduleMap.put(time,event);
    }

    @Override
    public void startEvent(Event event){
        upcomingEventScheduleMap.remove(event);
        this.currentRunningEvent = event;
    }

    @Override
    public Event getEventAt(String time) {
        return upcomingEventScheduleMap.get(time);
    }

    @Override
    public int getNumberOfAvailableSeats() {
        return this.numberOfAvailablePremiumSeats+this.numberOfAvailableNormalSeats;
    }

    @Override
    public Event getCurrentEvent() {
        return this.currentRunningEvent;
    }

    public Seats bookNormalSeat(int seatNumber){
        return this.seats.get(seatNumber);
    }

}
