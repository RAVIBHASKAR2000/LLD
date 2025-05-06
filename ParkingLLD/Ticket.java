package ParkingLLD;
import java.time.LocalDateTime;

public class Ticket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final LocalDateTime entryTime;
    private final ParkingFloor floor;
    private ParkingSpot spot;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot spot, ParkingFloor floor) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
        this.floor =  floor;
    }

    public ParkingFloor getFloor() {
        return floor;
    }

    public double calculateFare() {
        long hours = java.time.Duration.between(entryTime, LocalDateTime.now()).toHours();
        return Math.max(10, hours * 10); // Minimum 10 units, else 10 units per hour
    }

    public String getTicketId() {
        return ticketId;
    }

    public ParkingSpot getSpot() {
        return spot;
    }
}
