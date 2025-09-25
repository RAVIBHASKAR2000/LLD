package main.java.org.lldProblemStatements.RideSharingApp;

public interface RideMatchingController {
    Trip findRide(Passenger p1, Location destination, Vehicle vehicle);
}


// create a vehicleFactory