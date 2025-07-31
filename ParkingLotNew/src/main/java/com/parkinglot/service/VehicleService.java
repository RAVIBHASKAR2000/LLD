package main.java.com.parkinglot.service;

public class VehicleService {
    private Map<String, Vehicle> vehicles = new HashMap<>();

    public Vehicle getOrCreateVehicle(String id, String number, String user, VehicleType type) {
        if (vehicles.containsKey(number)) return vehicles.get(number);
        Vehicle v = switch (type) {
            case TWO_WHEELER -> new TwoWheelerVehicle(id, number, user);
            case FOUR_WHEELER -> new FourWheelerVehicle(id, number, user);
            case HEAVY_VEHICLE -> new HeavyVehicle(id, number, user);
        };
        vehicles.put(number, v);
        return v;
    }
}
