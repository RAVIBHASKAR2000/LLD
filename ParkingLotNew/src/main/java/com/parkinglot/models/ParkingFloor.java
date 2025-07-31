package main.java.com.parkinglot.models;

import java.util.*;

public class ParkingFloor {
    private String floorID;
    private int floorNumber;
    private List<ParkingSpot> spots;
    private ParkingLot parkingLot;
    private int size;

    public ParkingFloor(int floorNumber, int size) {
        this.floorNumber = floorNumber;
        this.size = size;
        this.spots = new ArrayList<>();
    }

    public void addSpot(ParkingSpot spot) {
        spots.add(spot);
    }
}
