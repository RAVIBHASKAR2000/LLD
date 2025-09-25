package main.java.com.Flipkart.repository;
import  main.java.com.Flipkart.model.Booking;

import java.util.*;

public class BookingRepository {
    private static BookingRepository instance = null;

    private Map<String, Booking> bookingMap = new HashMap<>();
    private Map<String, List<Booking>> userBookings = new HashMap<>();
    private Map<String, Integer> showBookingCounts = new HashMap<>();

    private BookingRepository() {}

    public static BookingRepository getInstance() {
        if (instance == null) {
            instance = new BookingRepository();
        }
        return instance;
    }

    public void addBooking(Booking booking) {
        bookingMap.put(booking.getBookingId(), booking);
        userBookings.computeIfAbsent(booking.getUsername(), k -> new ArrayList<>()).add(booking);
        showBookingCounts.put(booking.getShowName(),
                showBookingCounts.getOrDefault(booking.getShowName(), 0) + booking.getNumPersons());
    }

    public Booking getBooking(String bookingId) {
        return bookingMap.get(bookingId);
    }

    public List<Booking> getUserBookings(String user) {
        return userBookings.getOrDefault(user, new ArrayList<>());
    }

    public void cancelBooking(String bookingId) {
        Booking b = bookingMap.remove(bookingId);
        if (b != null) {
            userBookings.get(b.getUsername()).remove(b);
            showBookingCounts.put(b.getShowName(),
                    showBookingCounts.getOrDefault(b.getShowName(), 0) - b.getNumPersons());
        }
    }
}