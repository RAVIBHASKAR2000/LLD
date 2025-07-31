package main.java.com.parkinglot.models;

public abstract class ParkingSpot  {
    protected String spotID;
    protected String parkingSpotName;
    protected Vehicle vehicleParked;
    protected boolean isAvailable = true;
    protected ParkingFloor floor;
    protected ParkingSpotType spotType;
    protected double basePricePerHour;

    public ParkingSpot(ParkingFloor floor, double basePricePerHour, String parkingSpotName) {
        this.floor = floor;
        this.basePricePerHour = basePricePerHour;
        this.parkingSpotName = parkingSpotName;
        this.isAvailable = true;
    }

    public abstract void park(Vehicle vehicle);
    public abstract void unpark(Vehicle vehicle);

    public ParkingSpotType getSpotType() {
        return this.spotType;
    }

}
