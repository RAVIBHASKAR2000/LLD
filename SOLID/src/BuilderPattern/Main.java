package BuilderPattern;

public class Main {
    public static void main(String[] args){
        House house = new House.Builder()
                        .setWalls("Brick Walls")
                        .setRoof("Concrete Roof")
                        .setGarage(true)
                        .setSwimmingPool(false)
                        .build();
        house.showDetails();


    }
}
