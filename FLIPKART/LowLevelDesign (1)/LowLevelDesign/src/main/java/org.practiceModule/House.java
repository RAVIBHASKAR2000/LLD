package main.java.org.practiceModule;

public class House {

    private String roof;
    private String foundation;
    private String walls;
    private int floor;
    private boolean hasSwimmingPool;
    private boolean hasClubHouse;
    private boolean hasGarden;

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

    public static class HouseBuilder{
        private String roof;
        private String foundation;
        private String walls;
        private int floor;
        private boolean hasSwimmingPool;
        private boolean hasClubHouse;
        private boolean hasGarden;

        public HouseBuilder(String roof, String foundation, String walls, int floor) {
            this.roof = roof;
            this.foundation = foundation;
            this.walls = walls;
            this.floor = floor;
        }

        public HouseBuilder hasSwimmingPool(boolean hasSwimmingPool){
            this.hasSwimmingPool = hasSwimmingPool;
            return this;
        }

        public HouseBuilder hasClubHouse(boolean hasClubHouse){
            this.hasClubHouse = hasClubHouse;
            return this;
        }

        public HouseBuilder hasGarden(boolean hasGarden){
            this.hasGarden = hasGarden;
            return this;
        }

        public House build(){
            return new House(this);
        }
    }

    private House(HouseBuilder houseBuilder) {
        this.roof = houseBuilder.roof;
        this.foundation = houseBuilder.foundation;
        this.walls = houseBuilder.walls;
        this.floor = houseBuilder.floor;
        this.hasSwimmingPool = houseBuilder.hasSwimmingPool;
        this.hasGarden = houseBuilder.hasGarden;
        this.hasClubHouse = houseBuilder.hasClubHouse;
    }

}
