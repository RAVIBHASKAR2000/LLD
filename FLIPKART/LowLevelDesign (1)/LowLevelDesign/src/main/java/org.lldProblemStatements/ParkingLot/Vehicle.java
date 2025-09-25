package main.java.org.lldProblemStatements.ParkingLot;

public abstract class Vehicle{
    protected String vehicleNumber;
    protected String ownerName;

    public Vehicle(String vehicleNumber, String ownerName){
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    public String getVehicleNumber(){
        return this.vehicleNumber;
    }

    public String ownerName(){
        return this.ownerName;
    }
}