package main.java.org.lld.ObserverPattern;

public class ObserverDesktopDevice implements Observer {

    private float temp;

    @Override
    public void update(float temp) {
        this.temp = temp;
        displayTemperature();
    }

    public void displayTemperature(){
        System.out.printf("The temperature in Desktop is: %s\n",this.temp);
    }
}
