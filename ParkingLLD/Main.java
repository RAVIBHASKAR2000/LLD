package ParkingLLD;


public class Main {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot();
        ParkingFloor floor1 = new ParkingFloor("F1");

        floor1.addSpot(new ParkingSpot("S1", SpotType.COMPACT, 5));
        floor1.addSpot(new ParkingSpot("S2", SpotType.COMPACT, 3));
        floor1.addSpot(new ParkingSpot("S3", SpotType.BIKE, 2));

        lot.addFloor(floor1);

        Vehicle car = new Car("KA-01-1234");
        Ticket ticket = lot.parkVehicle(car);
        System.out.println("Ticket issued: " + ticket.getTicketId());

        double fare = lot.unparkVehicle(ticket.getTicketId());
        System.out.println("Parking fare: " + fare);
    }
}