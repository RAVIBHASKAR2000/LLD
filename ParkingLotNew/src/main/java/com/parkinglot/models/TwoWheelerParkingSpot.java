package main.java.com.parkinglot.models;



public class TwoWheelerParkingSpot extends ParkingSpot {
    public TwoWheelerParkingSpot(ParkingFloor floor, double basePricePerHour, String parkingSpotName) {
        super(floor, basePricePerHour, parkingSpotName);
        this.spotType = ParkingSpotType.TWO_WHEELER;
    }

    @Override
    public void park(Vehicle vehicle) {
        this.vehicleParked = vehicle;
        this.isAvailable = false;
    }

    @Override
    public void unpark(Vehicle vehicle) {
        this.vehicleParked = null;
        this.isAvailable = true;
    }
}

