package main.java.org.lldProblemStatements.ElevatorSystem;

import java.util.*;

public class ElevatorController {
    private List<Elevator> elevators;

    public ElevatorController(int numberOfElevators){
        elevators = new ArrayList<>();
        for(int i=0;i<numberOfElevators;i++){
            elevators.add(new Elevator());
        }
    }

    private Elevator findNearestElevator(int destination, int requestFloor){
        Elevator elevator = null;
        int minDistance = Integer.MAX_VALUE;

        // find an elevator that is nearest and is idle
        for(Elevator ele : elevators){
            if(ele.getCurrentState().getClass().getSimpleName().equals(ElevatorStopState.class.getSimpleName()) && ((Math.abs(ele.getCurrentFloor()-requestFloor))<minDistance)){
                elevator = ele;
                minDistance = (Math.abs(ele.getCurrentFloor()-requestFloor));
            }
        }
        if (elevator!=null){ return elevator;}

        // if no idle elevators are present then find out the closest destinationValue
        for(Elevator ele : elevators) {
            if ((Math.abs(ele.getDestinationFloor() - requestFloor)) < minDistance) {
                elevator = ele;
                minDistance = Math.abs(ele.getDestinationFloor() - requestFloor);
            }
        }

        return elevator;
    }

    public void requestElevator(int destination, int requestFloor){
        // check if there are any elevators present or not
        if(elevators.size()==0){
            System.out.println("No elevators are present!");
            return;
        }

        Elevator elevator = findNearestElevator(destination,requestFloor);

        elevator.handleRequest(destination);

    }

}
