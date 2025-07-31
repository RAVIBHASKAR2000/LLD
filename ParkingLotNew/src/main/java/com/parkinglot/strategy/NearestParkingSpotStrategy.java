package main.java.com.parkinglot.strategy;
import  main.java.com.parkinglot.models.*;

class NearestParkingSpotStrategy implements ParkingSpotFinder {
    public ParkingSpot findParkingSpot(ParkingLot parkingLot, Vehicle vehicle) {
        for (ParkingFloor floor : parkingLot.getFloors()) {
            for (ParkingSpot spot : floor.getSpots()) {
                if (spot.isAvailable && spot.spotType.toString().contains(vehicle.getClass().getSimpleName().toUpperCase())) {
                    return spot;
                }
            }
        }
        return null;
    }
}