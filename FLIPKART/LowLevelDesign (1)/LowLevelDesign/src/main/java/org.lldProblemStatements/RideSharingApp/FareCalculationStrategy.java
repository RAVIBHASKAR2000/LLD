package main.java.org.lldProblemStatements.RideSharingApp;

import org.jetbrains.annotations.NotNull;

public interface FareCalculationStrategy {
    double getFare(double distance, Vehicle vehicle);
}

class CarFareCalculationStrategy implements FareCalculationStrategy{

    @Override
    public double getFare(double distance, @NotNull Vehicle vehicle){
        return vehicle.getBaseFare()*distance;
    }
}

class BikeFareCalculationStrategy implements FareCalculationStrategy{
    @Override
    public double getFare(double distance, @NotNull Vehicle vehicle){
        return vehicle.getBaseFare()*distance;
    }
}

class FareCalcStrategyFactory{
    public static FareCalculationStrategy getFareCalculationStrategy(String vehicle){
        switch(vehicle){
            case "Car":
                return new CarFareCalculationStrategy();
            case "Bike":
                return new BikeFareCalculationStrategy();
            default:
                System.out.println("Not a valid type of vehicle");
                return new CarFareCalculationStrategy();
        }
    }
}