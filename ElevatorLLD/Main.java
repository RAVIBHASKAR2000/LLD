package ElevatorLLD;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Lift lift1 = new Lift(1);
        Lift lift2 = new Lift(2);

        Scheduler scheduler = new Scheduler(List.of(lift1, lift2));

        scheduler.handleRequest(new PassengerRequest(3, 7));
        scheduler.handleRequest(new PassengerRequest(2, 0));

        for (int i = 0; i < 10; i++) {
            System.out.println("\n--- Step " + (i + 1) + " ---");
            scheduler.stepAll();
        }
    }
}
