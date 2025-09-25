package models;

import java.time.LocalDateTime;
import java.util.*;

public class Booking {
    private String bookingId;
    private Customer customer;
    private Show show;
    private List<Ticket> tickets;
    private LocalDateTime bookingDate;
    private double totalAmount;
    private BookingStatus status;
    private int numberOfSeats;

    public Booking(String bookingId, Customer customer, Show show, List<Seat> seats) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.show = show;
        this.bookingDate = LocalDateTime.now();
        this.numberOfSeats = seats.size();
        this.status = BookingStatus.PENDING;
        this.tickets = new ArrayList<>();

        // Calculate total amount and create tickets
        this.totalAmount = 0;
        for (Seat seat : seats) {
            double seatPrice = seat.calculatePrice(show.getPrice());
            this.totalAmount += seatPrice;
            this.tickets.add(new Ticket(
                    "T" + System.currentTimeMillis() + tickets.size(),
                    seat.getSeatNumber(),
                    seatPrice,
                    bookingDate
            ));
        }
    }

    public boolean cancelBooking() {
        if (status == BookingStatus.CONFIRMED) {
            status = BookingStatus.CANCELLED;
            return true;
        }
        return false;
    }

    public void confirmBooking() {
        status = BookingStatus.CONFIRMED;
        customer.addBooking(this);
    }

    // Getters
    public String getBookingId() { return bookingId; }
    public Customer getCustomer() { return customer; }
    public Show getShow() { return show; }
    public double getTotalAmount() { return totalAmount; }
    public BookingStatus getStatus() { return status; }
    public List<Ticket> getTickets() { return tickets; }
}
