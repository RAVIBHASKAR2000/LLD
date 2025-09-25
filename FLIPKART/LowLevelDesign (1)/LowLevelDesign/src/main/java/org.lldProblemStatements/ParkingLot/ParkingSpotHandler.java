package main.java.org.lldProblemStatements.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotHandler {
    private static int perFloorCapacity = 100;
    private static int floors;
    private static List<List<ParkingSpot>> parkingSpots = new ArrayList<>();

    public static void initializeParkingSpots(int floors) {
        ParkingSpotHandler.floors = floors;
        System.out.println("Initializing all the parking spots on "+floors+ " floors");
        for (int i = 0; i < floors; i++) {
            List<ParkingSpot> p = new ArrayList<>();
            for (int j = 0; j < perFloorCapacity; j++) {
                if (j < 50) {
                    p.add(new CarParkingSpot(i,j));
                } else {
                    p.add(new BikeParkingSpot(i,j));
                }
                parkingSpots.add(p);
            }
        }
    }

    public static ParkingSpot findParkingSpot(Vehicle vehicle) {
        // simple findParkingSpot TC O(n^2) SC O(1)
        for (int i = 0; i < ParkingSpotHandler.floors; i++) {
            for (int j = 0; j < ParkingSpotHandler.perFloorCapacity; j++) {
                if (parkingSpots.get(i).get(j).isEmpty() && parkingSpots.get(i).get(j).getClass().getSimpleName().contains(vehicle.getClass().getSimpleName())) {
                    return parkingSpots.get(i).get(j);
                }
            }
        }

        System.out.println("No parking spot is available! Sorry for the inconvenience!");

        return null;
    }
}
