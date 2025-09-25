package main.java.org.lldProblemStatements.bookMyShow.models;

import java.util.UUID;

public class Booking {
    private final UUID bookingID;
    private final Movie movie;
    private final User user;
    private BookingStatus status;
    private Seat seat;
    private final double price;

    public Booking(UUID bookingID, Movie movie, Theater theater, User user, double price) {
        this.bookingID = bookingID;
        this.movie = movie;
        this.user = user;
        this.status = BookingStatus.ACTIVE;
        this.price = price;
    }

    public UUID getBookingID() {
        return bookingID;
    }

    public Movie getMovie() {
        return movie;
    }


    public User getUser() {
        return user;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
