package models;

public class ReclinerSeat extends  Seat{
    private double premiumPrice;

    public ReclinerSeat(String seatId, String seatNumber, String row) {
        super(seatId, seatNumber, row);
        this.premiumPrice = 1.5; // 50% premium
    }

    @Override
    public double calculatePrice(double basePrice) {
        return basePrice * premiumPrice;
    }
}
