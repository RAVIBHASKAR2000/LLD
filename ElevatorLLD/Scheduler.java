package ElevatorLLD;
import java.util.*;

public class Scheduler {
    List<Lift> lifts;
    List<PassengerRequest> waitingRequests = new ArrayList<>();

    public Scheduler(List<Lift> lifts) {
        this.lifts = lifts;
    }

    public void handleRequest(PassengerRequest pr) {
        waitingRequests.add(pr);
        Lift bestLift = findBestLift(pr);
        if (bestLift != null) {
            bestLift.addExternalRequest(pr.fromFloor);
        }
    }

    private Lift findBestLift(PassengerRequest pr) {
        Lift bestLift = null;
        int minDistance = Integer.MAX_VALUE;

        for (Lift lift : lifts) {
            int distance = Math.abs(lift.getCurrentFloor() - pr.fromFloor);
            if (lift.getStatus() == LiftStatus.IDLE && distance < minDistance) {
                minDistance = distance;
                bestLift = lift;
            }
        }

        return bestLift != null ? bestLift : lifts.get(0); // fallback
    }

    public void stepAll() {
        for (Lift lift : lifts) {
            lift.step(waitingRequests);
        }
    }
}