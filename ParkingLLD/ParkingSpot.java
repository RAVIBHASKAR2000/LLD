package ParkingLLD;



public class ParkingSpot implements Comparable<ParkingSpot> {
    private final String id;
    private final SpotType type;
    private boolean isFree;
    private final int distanceFromEntrance;
    private Vehicle parkedVehicle;

    public ParkingSpot(String id, SpotType type, int distanceFromEntrance) {
        this.id = id;
        this.type = type;
        this.isFree = true;
        this.distanceFromEntrance = distanceFromEntrance;
    }

    public boolean assignVehicle(Vehicle vehicle) {
        if (!isFree) return false;
        this.parkedVehicle = vehicle;
        this.isFree = false;
        return true;
    }

    public void removeVehicle() {
        this.parkedVehicle = null;
        this.isFree = true;
    }

    public boolean isFree() {
        return isFree;
    }

    public SpotType getType() {
        return type;
    }

    @Override
    public int compareTo(ParkingSpot other) {
        return Integer.compare(this.distanceFromEntrance, other.distanceFromEntrance);
    }
}