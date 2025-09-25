package main.java.org.lldProblemStatements.RideSharingApp;

public class Trip {
    private Passenger passenger;
    private Driver driver;
    private double fare;
    private double distance;
    private String status;

    public Trip(Passenger passenger, Driver driver, double distance, double fare) {
        this.passenger = passenger;
        this.driver = driver;
        this.distance = distance;
        this.fare = fare;
        this.status = String.valueOf(TripStatus.WAITING_FOR_PASSENGER);
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Driver getDriver() {
        return driver;
    }

    public double getDistance() {
        return distance;
    }

    public double getFare() {
        return new CarFareCalculationStrategy().getFare(distance, driver.getVehicle());
    }

    public void updateStatus(TripStatus status){
        this.status = String.valueOf(status);
        notifyTripUpdates(this.passenger, status);
        notifyTripUpdates(this.driver, status);
    }

    private void notifyTripUpdates(User user, TripStatus status){
        NotifyTripUpdatesUsers.notifyUser(user, "Alert! Your ride status was updated!\nThe current status is "+ status+"\n");
    }
}
