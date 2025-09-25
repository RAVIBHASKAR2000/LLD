package main.java.org.lld.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject{

    private float temperature;
    private List<Observer> observers;

    public WeatherStation(){
        this.observers = new ArrayList<Observer>();
    }

    public void setTemperature(float temp){
        this.temperature = temp;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for(Observer obs: this.observers){
            obs.update(this.temperature);
        }
    }
}
