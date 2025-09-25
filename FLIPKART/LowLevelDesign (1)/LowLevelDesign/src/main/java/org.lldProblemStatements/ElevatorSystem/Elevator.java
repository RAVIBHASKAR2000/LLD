package main.java.org.lldProblemStatements.ElevatorSystem;

import java.util.LinkedList;
import java.util.Queue;

public class Elevator {
    private int destinationFloor;
    private ElevatorState currentState;
    private int currentFloor;

    private Queue<Integer> elevatorQueue;
    public Elevator(){
        elevatorQueue = new LinkedList<>();
        currentState = new ElevatorStopState();
        currentFloor = 0;
        destinationFloor = -1;
    }

    public Queue<Integer> getElevatorQueue() {
        return elevatorQueue;
    }
    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public void handleRequest(int destination){
        currentState.handleRequest(destination, this);
        currentState.move(this);
    }

    public ElevatorState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(ElevatorState currentState) {
        this.currentState = currentState;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
}
