package main.java.org.lld.BuilderPattern;

public class HouseHandler {
    public static void main(String[] args){
        House newHouse = new HouseBuilder("Concrete","Concrete", 1, "Bricks and Cement")
                .hasGarden(true)
                .hasClubHouse(true)
                .hasSwimmingPool(true)
                .build();

        System.out.println(newHouse.isHasSwimmingPool());
    }
}
