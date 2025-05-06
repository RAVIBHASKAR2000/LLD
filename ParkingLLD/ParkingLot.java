package ParkingLLD;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingLot {
    private final Map<String, ParkingFloor> floors;
    private final Map<String, Ticket> activeTickets;

    public ParkingLot() {
        this.floors = new HashMap<>();
        this.activeTickets = new HashMap<>();
    }

    public void addFloor(ParkingFloor floor) {
        floors.put(floor.getFloorId(), floor);
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : floors.values()) {
            ParkingSpot spot = floor.getClosestSpot(vehicle.getType());
            if (spot != null && spot.isFree()) {
                floor.parkVehicle(vehicle);
                Ticket ticket = new Ticket(UUID.randomUUID().toString(), vehicle, spot, floor);
                activeTickets.put(ticket.getTicketId(), ticket);
                return ticket;
            }
        }
        throw new RuntimeException("Parking Full!");
    }

    public double unparkVehicle(String ticketId) {
        Ticket ticket = activeTickets.remove(ticketId);
        if (ticket == null) throw new RuntimeException("Invalid Ticket ID!");

        ParkingSpot spot = ticket.getSpot();
        ParkingFloor floor = ticket.getFloor();

        floor.unparkVehicle(spot);
        return ticket.calculateFare();
    }
}
