package models;

import java.time.LocalDateTime;

public class Ticket {
    private String ticketId;
    private String seatNumber;
    private double price;
    private LocalDateTime bookingTime;

    public Ticket(String ticketId, String seatNumber, double price, LocalDateTime bookingTime) {
        this.ticketId = ticketId;
        this.seatNumber = seatNumber;
        this.price = price;
        this.bookingTime = bookingTime;
    }

    public String generateTicket() {
        return "Ticket ID: " + ticketId + "\nSeat: " + seatNumber + "\nPrice: $" + price;
    }

    public boolean validateTicket() {
        return ticketId != null && !ticketId.isEmpty();
    }

    // Getters
    public String getTicketId() { return ticketId; }
    public String getSeatNumber() { return seatNumber; }
    public double getPrice() { return price; }
}
