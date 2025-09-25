package main.java.org.lldProblemStatements.RideSharingApp;

import org.jetbrains.annotations.NotNull;

public class Location {
    private double latitude;
    private double longitude;

    public Location(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getDistance(@NotNull Location location){
        return Math.abs(this.latitude-location.latitude) + Math.abs(this.longitude-location.longitude);
    }

}
