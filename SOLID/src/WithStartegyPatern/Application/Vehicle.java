package WithStartegyPatern.Application;

import WithStartegyPatern.Strategy.DriveStartegy;

public class Vehicle {

    DriveStartegy driveObject;

    public  Vehicle(DriveStartegy obj){
        this.driveObject = obj;
    }

    public  void drive(){
        driveObject.Drive();
    }
}
