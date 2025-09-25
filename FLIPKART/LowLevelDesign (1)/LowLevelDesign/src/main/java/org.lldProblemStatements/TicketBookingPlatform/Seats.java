package main.java.org.lldProblemStatements.TicketBookingPlatform;

public abstract class Seats{
    protected String seatNumber;
    protected boolean isEmpty;
    protected User occupiedBy;

    public Seats(String seatNumber){
        this.seatNumber = seatNumber;
        this.isEmpty = true;
    }

    abstract void bookSeat(User user);
    abstract void freeSeat();

    public boolean isEmpty(){
        return this.isEmpty;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public User getOccupiedBy() {
        return occupiedBy;
    }
}
