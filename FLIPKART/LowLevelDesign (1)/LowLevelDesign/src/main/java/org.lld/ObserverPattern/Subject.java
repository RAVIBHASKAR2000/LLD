package main.java.org.lld.ObserverPattern;

public interface Subject {

    void addObserver(Observer obs);
    void removeObserver(Observer obs);
    void notifyObservers();

}
