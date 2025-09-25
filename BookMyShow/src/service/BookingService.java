package service;

import models.*;
import  java.util.*;


public  class BookingService {
    private Map<String, SeatHold> activeSeatHolds;
    private Map<String, Booking> bookings;

    public BookingService() {
        this.activeSeatHolds = new HashMap<>();
        this.bookings = new HashMap<>();
    }

    public SeatHold blockSeats(String userId, Show show, List<Seat> seats) {
        // Check if seats are available
        for (Seat seat : seats) {
            if (seat.getStatus() != SeatStatus.AVAILABLE) {
                throw new IllegalStateException("Seat " + seat.getSeatNumber() + " is not available");
            }
        }

        // Create seat hold
        String holdId = "HOLD" + System.currentTimeMillis();
        SeatHold seatHold = new SeatHold(holdId, userId, show, seats);

        // Block seats
        for (Seat seat : seats) {
            seat.setStatus(SeatStatus.BLOCKED);
        }

        activeSeatHolds.put(holdId, seatHold);

        System.out.println("Seats blocked for user " + userId + ". Hold ID: " + holdId);
        return seatHold;
    }

    public boolean releaseHold(String holdId) {
        SeatHold hold = activeSeatHolds.get(holdId);
        if (hold != null && hold.isActive()) {
            // Release seats
            for (Seat seat : hold.getSeats()) {
                seat.setStatus(SeatStatus.AVAILABLE);
            }
            hold.setActive(false);
            activeSeatHolds.remove(holdId);
            return true;
        }
        return false;
    }

    public Booking bookTickets(String holdId, Customer customer, PaymentService paymentService, String paymentMethod) {
        SeatHold hold = activeSeatHolds.get(holdId);

        if (hold == null || !hold.isActive() || hold.isExpired()) {
            throw new IllegalStateException("Invalid or expired seat hold");
        }

        if (!hold.getUserId().equals(customer.getUserId())) {
            throw new IllegalStateException("Hold belongs to different user");
        }

        // Create booking
        String bookingId = "BK" + System.currentTimeMillis();
        Booking booking = new Booking(bookingId, customer, hold.getShow(), hold.getSeats());

        // Process payment
        Payment payment = paymentService.processPayment(booking.getTotalAmount(), paymentMethod);

        if (payment.getStatus() == PaymentStatus.SUCCESS) {
            // Confirm booking
            booking.confirmBooking();

            // Update seat status to booked
            for (Seat seat : hold.getSeats()) {
                seat.setStatus(SeatStatus.BOOKED);
            }

            // Release hold
            hold.setActive(false);
            activeSeatHolds.remove(holdId);

            // Store booking
            bookings.put(bookingId, booking);

            System.out.println("Booking confirmed! Booking ID: " + bookingId);
            return booking;
        } else {
            // Payment failed, release hold
            releaseHold(holdId);
            throw new RuntimeException("Payment failed");
        }
    }

    public boolean cancelBooking(String bookingId) {
        Booking booking = bookings.get(bookingId);
        if (booking != null) {
            return booking.cancelBooking();
        }
        return false;
    }

    public List<Booking> getBookingHistory(String userId) {
        return bookings.values().stream()
                .filter(booking -> booking.getCustomer().getUserId().equals(userId))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public List<Show> searchAvailableShows(String movieId, String cityId) {
        // This would typically query database
        // For demo, returning empty list
        return new ArrayList<>();
    }

    // Cleanup expired holds
    public void cleanupExpiredHolds() {
        activeSeatHolds.entrySet().removeIf(entry -> {
            SeatHold hold = entry.getValue();
            if (hold.isExpired()) {
                for (Seat seat : hold.getSeats()) {
                    seat.setStatus(SeatStatus.AVAILABLE);
                }
                return true;
            }
            return false;
        });
    }
}
