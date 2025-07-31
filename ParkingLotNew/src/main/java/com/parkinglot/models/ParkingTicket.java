package main.java.com.parkinglot.models;
import  java.util.*;

public class ParkingTicket {
    private String ticketID;
    private Vehicle vehicle;
    private ParkingSpot spot;
    private long entryTime;
    private long exitTime;

    public ParkingTicket(Vehicle vehicle, ParkingSpot spot) {
        this.ticketID = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = System.currentTimeMillis();
    }

    public void exit(long exitTime) {
        this.exitTime = exitTime;
    }

    public long getDurationInHours() {
        return (exitTime - entryTime) / 3600000;
    }
}
