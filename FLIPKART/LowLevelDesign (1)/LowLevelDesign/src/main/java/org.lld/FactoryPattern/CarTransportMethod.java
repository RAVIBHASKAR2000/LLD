package main.java.org.lld.FactoryPattern;

public class CarTransportMethod implements TransportFactoryInterface{
    @Override
    public void travel() {
        System.out.println("I'm travelling in a car!");
    }
}
