package main.java.org.lldProblemStatements.bookMyShow.models;

public class Seat {
    private final int seatNumber;
    private final SeatType seatType;
    private final Theater theater;
    private boolean isOccupied;

    public Seat(int seatNumber, SeatType seatType, Theater theater) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.theater = theater;
        isOccupied = false;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public Theater getTheater() {
        return theater;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
