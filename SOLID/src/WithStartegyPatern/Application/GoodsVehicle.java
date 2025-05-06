package WithStartegyPatern.Application;

import WithStartegyPatern.Strategy.NormalDriveStrategy;

public class GoodsVehicle extends  Vehicle{

    public  GoodsVehicle(){
        super(new NormalDriveStrategy());
    }
}
