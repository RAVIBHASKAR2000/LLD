package service;

import models.*;

public class NotificationService {
    public void sendBookingConfirmation(Booking booking) {
        System.out.println("\n=== BOOKING CONFIRMATION ===");
        System.out.println("Dear " + booking.getCustomer().getUsername() + ",");
        System.out.println("Your booking is confirmed!");
        System.out.println("Booking ID: " + booking.getBookingId());
        System.out.println("Movie: " + booking.getShow().getMovie().getTitle());
        System.out.println("Date: " + booking.getShow().getShowDate());
        System.out.println("Time: " + booking.getShow().getShowTime());
        System.out.println("Total Amount: $" + booking.getTotalAmount());
        System.out.println("Seats: " + booking.getTickets().stream()
                .map(Ticket::getSeatNumber)
                .reduce("", (a, b) -> a + " " + b));
        System.out.println("Thank you for booking with BookMyShow!");
        System.out.println("===============================\n");
    }

    public void sendCancellationNotice(Booking booking) {
        System.out.println("\n=== BOOKING CANCELLATION ===");
        System.out.println("Dear " + booking.getCustomer().getUsername() + ",");
        System.out.println("Your booking has been cancelled.");
        System.out.println("Booking ID: " + booking.getBookingId());
        System.out.println("Refund will be processed within 5-7 business days.");
        System.out.println("=============================\n");
    }

    public void sendReminder(Booking booking) {
        System.out.println("\n=== SHOW REMINDER ===");
        System.out.println("Dear " + booking.getCustomer().getUsername() + ",");
        System.out.println("Reminder: Your show is starting soon!");
        System.out.println("Movie: " + booking.getShow().getMovie().getTitle());
        System.out.println("Time: " + booking.getShow().getShowTime());
        System.out.println("====================\n");
    }

    public void sendPromotion(Customer customer, String promotion) {
        System.out.println("\n=== SPECIAL OFFER ===");
        System.out.println("Dear " + customer.getUsername() + ",");
        System.out.println(promotion);
        System.out.println("===================\n");
    }
}
