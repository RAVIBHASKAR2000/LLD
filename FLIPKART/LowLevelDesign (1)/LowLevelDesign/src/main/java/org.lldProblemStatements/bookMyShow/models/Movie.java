package main.java.org.lldProblemStatements.bookMyShow.models;

import java.time.Duration;

public class Movie {
    private final String name;
    private double rating;
    private final int duration;

    public Movie(String name, double rating, int duration) {
        this.name = name;
        this.rating = rating;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        // add validating if the rating is more than 0 and less than or equal to 5
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }
}
