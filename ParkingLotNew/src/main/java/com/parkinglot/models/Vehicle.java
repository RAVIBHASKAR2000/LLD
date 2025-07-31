package main.java.com.parkinglot.models;


import java.util.*;
public class Vehicle {

    protected String vehicleID;
    protected String vehicleNumber;
    protected String userName;

    public Vehicle(String vehicleID, String vehicleNumber, String userName) {
        this.vehicleID = vehicleID;
        this.vehicleNumber = vehicleNumber;
        this.userName = userName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }
}
