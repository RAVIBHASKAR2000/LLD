package main.java.org.lldProblemStatements.ParkingLot;

import java.util.*;

public class ParkingLot {
    private HashMap<String,Ticket>  carSpotMap;

    public ParkingLot(int floor){
        carSpotMap = new HashMap<>();
        ParkingSpotHandler.initializeParkingSpots(floor);
    }

    public void parkVehicle(Vehicle vehicle){
        // find a parking spot
        ParkingSpot spot = ParkingSpotHandler.findParkingSpot(vehicle);
        if (spot!=null){
            // found a parking spot park vehicle there
            Ticket newTicket = spot.parkVehicle(vehicle);
            carSpotMap.put(vehicle.getVehicleNumber(),newTicket);
            System.out.println("Your vehicle is successfully parked in "+spot.getFloor()+"th floor and at spot number "+spot.getNumber());
        }
    }

    public void unParkVehicle(String vehicleNumber){
        // fetch the ticket of the user
        Ticket ticket = carSpotMap.get(vehicleNumber);
        if (carSpotMap.containsKey(vehicleNumber)) {
            // set the exit time
            ticket.setExitTime(891723789);
            // pay the ticket
            ticket.payTicket();

            // un park the vehicle from the spot
            ParkingSpot spot = ticket.getSpot();

            // remove the vehicle from the spot
            spot.removeVehicle();

            // remove the vehicle from the map
            carSpotMap.remove(vehicleNumber);

            System.out.println("Vehicle " + vehicleNumber + " successfully removed from the parking lot!");
        }
        else{
            System.out.println("Invalid vehicle number!");
        }
    }
}
