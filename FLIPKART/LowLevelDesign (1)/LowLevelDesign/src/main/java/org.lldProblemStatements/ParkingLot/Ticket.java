package main.java.org.lldProblemStatements.ParkingLot;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private String ticketID;
    private Vehicle vehicle;
    private int entryTime;
    private int exitTime;
    private int charges;


    private ParkingSpot spot;
    private boolean isPaid;

    public Ticket(Vehicle vehicle, ParkingSpot spot){
        ticketID = String.valueOf(UUID.randomUUID());
        this.vehicle = vehicle;
        entryTime = 871263817;
        isPaid = false;
        this.spot = spot;
    }

    public void payTicket(){
        System.out.println("Your total is: "+(spot.perHourCharge()*Math.abs(exitTime-entryTime)));
        System.out.println("Redirecting to payment page!");
        System.out.println("Payment successful!");
        isPaid = true;
    }

    public ParkingSpot getSpot() {
        return spot;
    }
    public boolean isPaid(){
        return this.isPaid;
    }

    public void setExitTime(int exitTime) {
        this.exitTime = exitTime;
    }
}
