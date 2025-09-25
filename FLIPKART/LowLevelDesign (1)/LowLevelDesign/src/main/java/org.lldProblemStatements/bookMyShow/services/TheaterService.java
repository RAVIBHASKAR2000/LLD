package main.java.org.lldProblemStatements.bookMyShow.services;

import main.java.org.lldProblemStatements.bookMyShow.models.Theater;
import main.java.org.lldProblemStatements.bookMyShow.models.Booking;
import main.java.org.lldProblemStatements.bookMyShow.models.User;
import main.java.org.lldProblemStatements.bookMyShow.models.Movie;
import main.java.org.lldProblemStatements.bookMyShow.models.Seat;

import java.util.HashMap;

public class TheaterService {
    private HashMap<String, Theater> theaters;
    private HashMap<String, Booking> bookings;
    private static TheaterService instance;

    private TheaterService(){
        this.theaters = new HashMap<>();
        this.bookings = new HashMap<>();
    }

    public static TheaterService getInstance(){
        if(instance==null){
            instance = new TheaterService();
        }
        return instance;
    }

    public void addTheater(String theaterName){
        theaters.put(theaterName,new Theater(theaterName));
    }

    public void removeTheater(String theaterName){
        theaters.remove(theaterName);
    }

//    public Booking createBooking(Theater theater, User user, Movie movie, Seat seat, int startingTime){
//
//    }

}
