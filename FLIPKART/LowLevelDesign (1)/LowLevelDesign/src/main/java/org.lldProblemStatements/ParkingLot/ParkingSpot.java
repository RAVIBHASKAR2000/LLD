package main.java.org.lldProblemStatements.ParkingLot;

public interface ParkingSpot{
    Ticket parkVehicle(Vehicle vehicle);
    void removeVehicle();
    boolean isEmpty();
    double perHourCharge();
    int getFloor();
    int getNumber();
}