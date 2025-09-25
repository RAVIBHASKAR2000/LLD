package main.java.org.lld.ObserverPattern;

public class WeatherStationHandler {
    // create and onboard devices
    public static void main(String args[]){
        ObserverDesktopDevice desktop = new ObserverDesktopDevice();
        ObserverMobileDevice mobile = new ObserverMobileDevice();

        WeatherStation weatherStation = new WeatherStation();

        weatherStation.addObserver(desktop);
        weatherStation.addObserver(mobile);

        weatherStation.setTemperature(26.7f);
        weatherStation.setTemperature(31.2f);
        weatherStation.removeObserver(mobile);
        weatherStation.setTemperature(21.2f);
    }
}
