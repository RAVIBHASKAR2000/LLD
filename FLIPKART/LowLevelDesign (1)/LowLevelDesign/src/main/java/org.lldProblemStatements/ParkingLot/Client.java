package main.java.org.lldProblemStatements.ParkingLot;

public class Client {
    public static void main(String[] args){
        ParkingLot parkingLot = new ParkingLot(2);
        Car akshayCar = new Car("TS-07-EW-3656","Akshay");
        Bike akshayBike = new Bike("TS-07-EW-4656","Akshay");

        parkingLot.parkVehicle(akshayCar);
        parkingLot.parkVehicle(akshayBike);

        parkingLot.unParkVehicle("TS-07-EW-3656");
        parkingLot.unParkVehicle("TS-07-EW-4656");

        parkingLot.unParkVehicle("TS-07-EW-3656");
    }
}
