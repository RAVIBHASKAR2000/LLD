package main.java.org.lld.FactoryPattern;

public class TransportTypeFactory {
    public static TransportFactoryInterface getTransportMethod(String name) throws Exception {
        switch(name){
            case "Car":
                return new CarTransportMethod();
            case "Bus":
                return new BusTransportMethod();
            case "Train":
                return new TrainTransportMethod();
            default:
                throw new Exception("Unknown transport type!");
        }
    }
}
