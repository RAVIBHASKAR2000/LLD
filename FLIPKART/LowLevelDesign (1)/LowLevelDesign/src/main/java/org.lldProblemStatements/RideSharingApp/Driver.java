package main.java.org.lldProblemStatements.RideSharingApp;

public class Driver extends User{
    private Vehicle vehicle;
    private Trip currentActiveTrip;

    public Driver(String name, String email, String phoneNumber, Location location, Vehicle vehicle){
        super(name,email,phoneNumber, location);
        this.vehicle = vehicle;
    }

    public boolean isDriving(){
        return !(currentActiveTrip==null);
    }

    public void setActiveTrip(Trip activeTrip){
        this.currentActiveTrip = activeTrip;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
