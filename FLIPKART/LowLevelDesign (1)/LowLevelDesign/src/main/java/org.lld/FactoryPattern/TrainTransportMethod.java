package main.java.org.lld.FactoryPattern;

public class TrainTransportMethod implements TransportFactoryInterface{
    @Override
    public void travel() {
        System.out.println("I'm travelling in train!");
    }
}