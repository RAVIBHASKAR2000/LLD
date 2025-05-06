package WithStartegyPatern.Application;

public class Main {
    public static void main(String[] args){

        Vehicle vehicle = new OffRoadVehicle();
        vehicle.drive();

        Vehicle v2 = new GoodsVehicle();

        v2.drive();

    }
}
