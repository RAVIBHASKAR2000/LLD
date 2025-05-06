package WithStartegyPatern.Strategy;

public class NormalDriveStrategy implements  DriveStartegy{

    @Override
    public void Drive() {
        System.out.println("Normal drive startegy");
    }
}
