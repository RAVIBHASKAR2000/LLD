package main.java.org.lldProblemStatements.ParkingLot;

import java.util.UUID;

public class BikeParkingSpot implements ParkingSpot {
    private Vehicle vehicle;
    private boolean isEmpty;
    int floor;
    int number;
    private String spotID;
    private Ticket ticket;

    public BikeParkingSpot(int floor, int number){
        this.floor = floor;
        this.number = number;
        isEmpty = true;
        spotID = String.valueOf(UUID.randomUUID());
    }

    public Vehicle getVehicle(){
        return this.vehicle;
    }

    @Override
    public Ticket parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isEmpty = false;
        this.ticket = new Ticket(vehicle, this);
        return this.ticket;
    }

    @Override
    public void removeVehicle() {
        this.vehicle = null;
        this.isEmpty = true;
    }

    @Override
    public boolean isEmpty() {
        return this.isEmpty;
    }

    @Override
    public double perHourCharge(){
        return 60.0;
    }

    public Ticket getTicketForTheSpot(){
        return this.ticket;
    }

    public int getFloor() {
        return this.floor;
    }

    public int getNumber() {
        return this.number;
    }
}
