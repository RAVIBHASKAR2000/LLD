package main.java.org.lld.FactoryPattern;

public class TransportService {
    public static void main(String[] args) throws Exception {
        TransportFactoryInterface car = TransportTypeFactory.getTransportMethod("Car");
        car.travel();

        TransportFactoryInterface bus = TransportTypeFactory.getTransportMethod("Bus");
        bus.travel();

        TransportFactoryInterface train = TransportTypeFactory.getTransportMethod("Train");
        train.travel();

        TransportFactoryInterface exp = TransportTypeFactory.getTransportMethod("Akshay");
        exp.travel();
    }
}
