package WithStartegyPatern.Application;

import WithStartegyPatern.Strategy.SportsDriveStartegy;

public class OffRoadVehicle extends  Vehicle{
    public  OffRoadVehicle(){

        super(new SportsDriveStartegy());
    }
}
