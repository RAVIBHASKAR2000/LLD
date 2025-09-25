package main.java.org.lld.BuilderPattern;

class HouseBuilder{
    public String roof;
    public String foundation;
    public String walls;
    public int floor;
    public boolean hasSwimmingPool;
    public boolean hasClubHouse;
    public boolean hasGarden;

    public HouseBuilder(String roof, String foundation, int floor, String walls){
        this.roof = roof;
        this.foundation = foundation;
        this.floor = floor;
        this.walls = walls;
    }

    public HouseBuilder hasGarden(boolean hasGarden){
        this.hasGarden = hasGarden;
        return this;
    }

    public HouseBuilder hasSwimmingPool(boolean hasSwimmingPool){
        this.hasSwimmingPool = hasSwimmingPool;
        return this;
    }

    public HouseBuilder hasClubHouse(boolean hasClubHouse){
        this.hasClubHouse = hasClubHouse;
        return this;
    }

    public House build(){
        return House.getInstance(this);
    }
}