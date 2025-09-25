package main.java.org.lldProblemStatements.TicketBookingPlatform;

public class PremiumSeats extends Seats {
    public PremiumSeats(String seatNumber) {
        super(seatNumber);
    }

    @Override
    void bookSeat(User user) {
        super.occupiedBy = user;
        super.isEmpty = false;
    }

    @Override
    void freeSeat() {
        super.occupiedBy = null;
        super.isEmpty = true;
    }
}
