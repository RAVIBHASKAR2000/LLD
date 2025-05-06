package ObserverPattern.observable;

import ObserverPattern.observer.NotificationAlertObserver;

public interface StocksObservable {
    public  void  add(NotificationAlertObserver observer);
    public  void remove(NotificationAlertObserver observer);

    public void notifySubscribers();

    public  void setStocks(int newStock);

    public  int getStocks();
}
