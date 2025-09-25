package models;


import java.time.LocalDate;
import  java.util.*;
public class Customer extends  User{
    private List<Booking> bookingHistory;
    private List<String> paymentMethods;

    public Customer(String userId, String username, String email, String phoneNumber, LocalDate dateOfBirth) {
        super(userId, username, email, phoneNumber, dateOfBirth);
        this.bookingHistory = new ArrayList<>();
        this.paymentMethods = new ArrayList<>();
    }

    public List<Movie> searchMovies(String query) {
        // This would typically call MovieService
        return new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        bookingHistory.add(booking);
    }

    public List<Booking> getBookingHistory() { return bookingHistory; }
}
