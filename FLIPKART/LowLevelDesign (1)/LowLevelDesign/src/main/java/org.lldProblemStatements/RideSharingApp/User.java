package main.java.org.lldProblemStatements.RideSharingApp;

import java.util.UUID;

abstract class User {
    protected String name;
    protected String email;
    protected String phoneNumber;
    protected Location location;
    protected UUID userID;
    public User(String name, String email, String phoneNumber, Location location){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.userID = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Location getCurrentLocation(){
        return this.location;
    }

    public void setLocation(Location currentLocation){
        this.location = currentLocation;
    }

}
