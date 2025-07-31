package main.java.com.parkinglot.service;


class ParkingSpotService {
    public void parkVehicle(Vehicle vehicle, ParkingSpot spot) {
        spot.park(vehicle);
    }

    public void unparkVehicle(Vehicle vehicle, ParkingSpot spot) {
        spot.unpark(vehicle);
    }
}
