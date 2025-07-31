package main.java.com.parkinglot.service;


class TicketService {
    private Map<String, ParkingTicket> tickets = new HashMap<>();

    public ParkingTicket createTicket(Vehicle vehicle, ParkingSpot spot) {
        ParkingTicket ticket = new ParkingTicket(vehicle, spot);
        tickets.put(ticket.ticketID, ticket);
        return ticket;
    }

    public ParkingTicket getTicket(String ticketID) {
        return tickets.get(ticketID);
    }

    public void removeTicket(String ticketID) {
        tickets.remove(ticketID);
    }
}