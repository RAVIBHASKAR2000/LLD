package ObserverPattern;

import ObserverPattern.observable.StocksObservable;
import ObserverPattern.observable.phoneObserverImpl;
import ObserverPattern.observer.EmailAlertObserverImpl;
import ObserverPattern.observer.MobileAlertObserverImpl;
import ObserverPattern.observer.NotificationAlertObserver;

public class Store {

    public  static void main(String args[]){
        StocksObservable  iphoneobserver = new phoneObserverImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl( "xyz@gmail.com", iphoneobserver);
        NotificationAlertObserver observer2 = new MobileAlertObserverImpl( "xyz", iphoneobserver);


        iphoneobserver.add(observer1);
        iphoneobserver.add(observer2);


        iphoneobserver.setStocks(10);
        iphoneobserver.setStocks(100);
          iphoneobserver.setStocks(0);
        iphoneobserver.setStocks(100);

    }
}
