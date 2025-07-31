package main.java.com.parkinglot.strategy;
import  main.java.com.parkinglot.models.*;



public interface ParkingSpotFinder {
    ParkingSpot findParkingSpot(ParkingLot parkingLot, Vehicle vehicle);
}
