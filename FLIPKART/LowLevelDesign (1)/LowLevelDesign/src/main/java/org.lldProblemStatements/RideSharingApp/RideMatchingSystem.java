package main.java.org.lldProblemStatements.RideSharingApp;

import java.util.ArrayList;
import java.util.List;

public class RideMatchingSystem {
    private static RideMatchingSystem instance;
    private static List<Driver> activeDrivers;
    private static List<Trip> activeTrips;

    private RideMatchingSystem(){
        activeDrivers = new ArrayList<>();
        activeTrips = new ArrayList<>();
    }

    public static RideMatchingSystem getInstance(){
        if(instance==null){
            instance = new RideMatchingSystem();
        }
        return instance;
    }

    public static synchronized void registerDriver(Driver driver){
        activeDrivers.add(driver);
    }

    public static synchronized void markDriverInactive(Driver driver){
        activeDrivers.remove(driver);
    }

    public static void addTrip(Trip trip){
        activeTrips.add(trip);
        trip.updateStatus(TripStatus.RUNNING);
    }

    public static void markTripOver(Trip trip){
        activeTrips.remove(trip);
        trip.updateStatus(TripStatus.REACHED_DESTINATION);
    }

    private static Driver findNearestDriver(Passenger p){
        Location passengerLocation = p.getCurrentLocation();
        int minDistance = Integer.MAX_VALUE;
        Driver currentDriver = null;
        for(Driver driver:activeDrivers){
            if(passengerLocation.getDistance(driver.getCurrentLocation())<=minDistance){
                currentDriver = driver;
            }
        }

        return currentDriver;
    }

    public static synchronized Trip findRide(Passenger p, Location destination, String vehicle){
        if(activeDrivers.size()==0){
            System.out.println("No active driver found!");
            return null;
        }

        Driver driver =  findNearestDriver(p);

        activeDrivers.remove(driver);

        double distance = destination.getDistance(p.getCurrentLocation());

        FareCalculationStrategy fareCalc = FareCalcStrategyFactory.getFareCalculationStrategy(vehicle);

        Trip trip = new Trip(p,driver,distance,fareCalc.getFare(distance, driver.getVehicle()));

        trip.updateStatus(TripStatus.RUNNING);

        return trip;
    }
}
