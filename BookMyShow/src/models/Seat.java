package models;

public abstract class Seat {
    protected String seatId;
    protected String seatNumber;
    protected SeatStatus status;
    protected String row;

    public Seat(String seatId, String seatNumber, String row) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.row = row;
        this.status = SeatStatus.AVAILABLE;
    }

    public abstract double calculatePrice(double basePrice);

    // Getters and Setters
    public String getSeatId() { return seatId; }
    public String getSeatNumber() { return seatNumber; }
    public SeatStatus getStatus() { return status; }
    public void setStatus(SeatStatus status) { this.status = status; }
}
