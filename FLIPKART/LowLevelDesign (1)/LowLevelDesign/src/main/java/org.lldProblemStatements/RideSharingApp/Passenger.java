package main.java.org.lldProblemStatements.RideSharingApp;

import java.util.UUID;

public class Passenger extends User{
    private Trip currentActiveTrip;

    public Passenger(String name, String email, String phoneNumber, Location location){
        super(name,email,phoneNumber, location);
    }

    public boolean isTravelling(){
        return !(currentActiveTrip==null);
    }

    public void setActiveTrip(Trip activeTrip){
        this.currentActiveTrip = activeTrip;
    }
}
