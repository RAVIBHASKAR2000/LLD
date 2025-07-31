package main.java.com.parkinglot.service;


class ReceiptService {
    private List<ParkingReceipt> receipts = new ArrayList<>();

    public ParkingReceipt generateReceipt(ParkingTicket ticket) {
        double total = ticket.calculateTotalAmount();
        ParkingReceipt receipt = new ParkingReceipt(ticket.getVehicle(), total, ticket.getEntryTime(), ticket.getExitTime());
        receipts.add(receipt);
        return receipt;
    }
}