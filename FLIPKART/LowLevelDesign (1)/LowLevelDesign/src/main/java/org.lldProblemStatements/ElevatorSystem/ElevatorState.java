package main.java.org.lldProblemStatements.ElevatorSystem;

import org.jetbrains.annotations.NotNull;

public interface ElevatorState {
    void handleRequest(int destination, Elevator elevator);
    public void move(Elevator elevator);
}

class ElevatorMovingState implements ElevatorState{
    public void handleRequest(int destination, Elevator elevator){
        elevator.getElevatorQueue().add(destination);
    }

    public void move(Elevator elevator){
        // send the internal machine command to move to next floor
        Integer nextDestination = elevator.getElevatorQueue().poll();
        if (nextDestination!=null){
            int next = nextDestination;
            elevator.setCurrentState(new ElevatorDoorOpenState());
            elevator.setCurrentFloor(next);
        }
        else{
            System.out.println("No pending requests!");
            elevator.setCurrentState(new ElevatorStopState());
        }
    }
}

class ElevatorStopState implements ElevatorState{
    public void handleRequest(int destination, Elevator elevator){
        elevator.getElevatorQueue().add(destination);
        elevator.setCurrentState( new ElevatorMovingState());
        elevator.setDestinationFloor(destination);
    }

    public void move(Elevator elevator){
        // no movement during idle state
    }
}

class ElevatorDoorOpenState implements ElevatorState{
    public void handleRequest(int destination, @NotNull Elevator elevator){
        elevator.getElevatorQueue().add(destination);
    }
    public void move(Elevator elevator){
        // wait for the door to close
//        Thread.sleep(1000);
        // poll the queue for pending requests and then fulfill them
        Integer nextDestination = elevator.getElevatorQueue().poll();
        if (nextDestination!=null){
            int next = nextDestination;
            // send the internal machine command to move to next floor
            elevator.setCurrentState(new ElevatorDoorOpenState());
            elevator.setCurrentFloor(next);
        }
        else{
            System.out.println("No pending requests!");
            elevator.setCurrentState(new ElevatorStopState());
        }
    }
}