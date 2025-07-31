package main.java.com.parkinglot.models;
import  java.util.*;

public class ParkingReceipt {
    private String receiptID;
    private double totalAmount;
    private long entryTime;
    private long exitTime;
    private Vehicle vehicle;

    public ParkingReceipt(Vehicle vehicle, double totalAmount, long entryTime, long exitTime) {
        this.receiptID = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.totalAmount = totalAmount;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }
}