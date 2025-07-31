package main.java.com.parkinglot.service;

import main.java.com.parkinglot.models.*;
import main.java.com.parkinglot.strategy.*;

import java.util.*;

public class ParkingLotService {
    private List<ParkingLot> parkingLots = new ArrayList<>();
    private ParkingSpotFinder spotFinder = new NearestParkingSpotStrategy();
    private VehicleService vehicleService = new VehicleService();
    private TicketService ticketService = new TicketService();
    private ReceiptService receiptService = new ReceiptService();
    private ParkingSpotService spotService = new ParkingSpotService();

    public void addParkingLot(ParkingLot lot) {
        parkingLots.add(lot);
    }

    public ParkingTicket vehicleEntry(String vehicleNumber, VehicleType type, long entryTime) {
        Vehicle vehicle = vehicleService.getOrCreateVehicle(UUID.randomUUID().toString(), vehicleNumber, "User", type);
        ParkingSpot spot = spotFinder.findParkingSpot(parkingLots.get(0), vehicle);
        if (spot == null) return null;
        spotService.parkVehicle(vehicle, spot);
        return ticketService.createTicket(vehicle, spot);
    }

    public ParkingReceipt vehicleExit(String ticketID, long exitTime) {
        ParkingTicket ticket = ticketService.getTicket(ticketID);
        ticket.exit(exitTime);
        spotService.unparkVehicle(ticket.getVehicle(), ticket.getSpot());
        ParkingReceipt receipt = receiptService.generateReceipt(ticket);
        ticketService.removeTicket(ticketID);
        return receipt;
    }


}
