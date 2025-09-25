package main.java.org.lldProblemStatements.bookMyShow.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Theater {
    private String name;
    private HashMap<SeatType,List<Seat>> seatMap;

    public Theater(String name) {
        this.name = name;
        this.seatMap = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public HashMap<SeatType, List<Seat>> getSeatMap() {
        return seatMap;
    }

    public void addSeat(Seat seat, SeatType seatType){
        if(seatMap.containsKey(seatType)) {
            seatMap.put(seatType, new ArrayList<>());
        }

        seatMap.get(seatType).add(seat);
    }

    public void removeSeat(Seat seat, SeatType seatType){
        seatMap.get(seatType).remove(seat);
    }
}
