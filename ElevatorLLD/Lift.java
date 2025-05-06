package ElevatorLLD;

import java.util.*;

public class Lift {
    private final int id;
    private int currentFloor;
    private LiftStatus status;
    private final TreeSet<Integer> upStops;
    private final TreeSet<Integer> downStops;

    public Lift(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.status = LiftStatus.IDLE;
        this.upStops = new TreeSet<>();
        this.downStops = new TreeSet<>((a, b) -> b - a); // Descending
    }

    public void addExternalRequest(int floor) {
        if (floor > currentFloor) {
            upStops.add(floor);
            if (status == LiftStatus.IDLE) status = LiftStatus.MOVING_UP;
        } else if (floor < currentFloor) {
            downStops.add(floor);
            if (status == LiftStatus.IDLE) status = LiftStatus.MOVING_DOWN;
        }
    }

    public void addInternalRequest(int floor) {
        addExternalRequest(floor); // same handling for now
    }

    public void step(List<PassengerRequest> waitingRequests) {
        if (status == LiftStatus.MOVING_UP) {
            currentFloor++;
            if (upStops.contains(currentFloor)) {
                upStops.remove(currentFloor);
                System.out.println("Lift " + id + " stopped at floor " + currentFloor);
                boardPassengers(waitingRequests);
                if (upStops.isEmpty() && downStops.isEmpty()) status = LiftStatus.IDLE;
            }
        } else if (status == LiftStatus.MOVING_DOWN) {
            currentFloor--;
            if (downStops.contains(currentFloor)) {
                downStops.remove(currentFloor);
                System.out.println("Lift " + id + " stopped at floor " + currentFloor);
                boardPassengers(waitingRequests);
                if (upStops.isEmpty() && downStops.isEmpty()) status = LiftStatus.IDLE;
            }
        }
    }

    private void boardPassengers(List<PassengerRequest> waitingRequests) {
        Iterator<PassengerRequest> iter = waitingRequests.iterator();
        while (iter.hasNext()) {
            PassengerRequest req = iter.next();
            if (req.fromFloor == currentFloor) {
                System.out.println("Passenger boarded at floor " + req.fromFloor + " going to " + req.toFloor);
                addInternalRequest(req.toFloor);
                iter.remove();
            }
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public LiftStatus getStatus() {
        return status;
    }
}
