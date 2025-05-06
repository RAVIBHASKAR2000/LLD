package ParkingLLD;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;



public class ParkingFloor {
    private final String floorId;
    private final Map<SpotType, PriorityQueue<ParkingSpot>> spotQueues;

    public ParkingFloor(String floorId) {
        this.floorId = floorId;
        this.spotQueues = new HashMap<>();
        for (SpotType type : SpotType.values()) {
            spotQueues.put(type, new PriorityQueue<>());
        }
    }

    public String getFloorId() {
        return floorId;
    }

    public void addSpot(ParkingSpot spot) {
        spotQueues.get(spot.getType()).add(spot);
    }

    public ParkingSpot getClosestSpot(VehicleType vehicleType) {
        SpotType type = mapVehicleToSpot(vehicleType);
        PriorityQueue<ParkingSpot> queue = spotQueues.get(type);
        return (queue == null || queue.isEmpty()) ? null : queue.peek();
    }

    public boolean parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = getClosestSpot(vehicle.getType());
        if (spot == null || !spot.isFree()) return false;
        spot.assignVehicle(vehicle);
        spotQueues.get(spot.getType()).remove(spot); // Remove from queue
        return true;
    }

    public void unparkVehicle(ParkingSpot spot) {
        spot.removeVehicle();
        spotQueues.get(spot.getType()).add(spot); // Add back to queue
    }

    private SpotType mapVehicleToSpot(VehicleType type) {
        switch (type) {
            case BIKE: return SpotType.BIKE;
            case CAR: return SpotType.COMPACT;
            case TRUCK: return SpotType.LARGE;
            default: throw new IllegalArgumentException("Unsupported vehicle type.");
        }
    }
}
