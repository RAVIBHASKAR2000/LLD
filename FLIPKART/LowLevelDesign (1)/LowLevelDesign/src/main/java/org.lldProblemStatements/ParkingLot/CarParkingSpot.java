package main.java.org.lldProblemStatements.ParkingLot;

import java.util.UUID;

public class CarParkingSpot implements ParkingSpot {
    private Vehicle vehicle;
    private int floor;
    private int number;
    private boolean isEmpty;
    private String spotID;
    private Ticket ticket;


    public CarParkingSpot(int floor, int number){
        this.floor = floor;
        this.number = number;
        isEmpty = true;
        spotID = String.valueOf(UUID.randomUUID());
    }

    @Override
    public Ticket parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.ticket = new Ticket(vehicle, this);
        this.isEmpty = false;

        return this.ticket;
    }

    @Override
    public void removeVehicle() {

        if(this.ticket.isPaid()){
            this.vehicle = null;
            this.isEmpty = true;
            this.ticket = null;
        }
        else{
            System.out.println("Could not un park the vehicle please pay the pending amount first");
        }
    }

    @Override
    public boolean isEmpty() {
        return this.isEmpty;
    }

    @Override
    public double perHourCharge(){
        return 100.0;
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
