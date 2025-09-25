package models;

public class RegularSeat extends Seat{
    private double price;

    public RegularSeat(String seatId, String seatNumber, String row) {
        super(seatId, seatNumber, row);
    }

    @Override
    public double calculatePrice(double basePrice) {
        return basePrice;
    }
}
