package main.java.com.parkinglot.models;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String parkingLotID;
    private List<ParkingFloor> floors;
    private int numberOfFloors;

    public ParkingLot(String parkingLotID, int numberOfFloors) {
        this.parkingLotID = parkingLotID;
        this.numberOfFloors = numberOfFloors;
        this.floors = new ArrayList<>();
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }
}