package ObserverPattern.observable;

import ObserverPattern.observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class phoneObserverImpl implements  StocksObservable{
    public List<NotificationAlertObserver> observersList = new ArrayList<>();
    public int stocks =0;


    @Override
    public void add(NotificationAlertObserver observer) {
        observersList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observersList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for(NotificationAlertObserver obj : observersList){
            obj.update();
        }
    }

    @Override
    public void setStocks(int stocks) {
        if(this.stocks ==0){
            notifySubscribers();
        }
        this.stocks = this.stocks + stocks;
    }


    @Override
    public int getStocks() {
        return stocks;
    }
}
