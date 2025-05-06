package ElevatorLLD;

class PassengerRequest {
    int fromFloor;
    int toFloor;

    public PassengerRequest(int from, int to) {
        this.fromFloor = from;
        this.toFloor = to;
    }

    public Direction getDirection() {
        return (toFloor > fromFloor) ? Direction.UP : Direction.DOWN;
    }
}
