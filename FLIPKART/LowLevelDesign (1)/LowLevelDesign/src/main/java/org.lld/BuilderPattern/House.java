package main.java.org.lld.BuilderPattern;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class House {
    public String getRoof() {
        return roof;
    }

    public String getFoundation() {
        return foundation;
    }

    public String getWalls() {
        return walls;
    }

    public int getFloor() {
        return floor;
    }

    public boolean isHasSwimmingPool() {
        return hasSwimmingPool;
    }

    public boolean isHasClubHouse() {
        return hasClubHouse;
    }

    public boolean isHasGarden() {
        return hasGarden;
    }

    private String roof;
    private String foundation;
    private String walls;
    private int floor;
    private boolean hasSwimmingPool;
    private boolean hasClubHouse;
    private boolean hasGarden;

    private House(HouseBuilder houseBuilder){
        this.roof = houseBuilder.roof;
        this.foundation = houseBuilder.foundation;
        this.floor = houseBuilder.floor;
        this.walls = houseBuilder.walls;
        this.hasSwimmingPool = houseBuilder.hasSwimmingPool;
        this.hasClubHouse = houseBuilder.hasClubHouse;
        this.hasGarden = houseBuilder.hasGarden;
    }

    public static House getInstance(HouseBuilder houseBuilder){
        return new House(houseBuilder);
    }
}
