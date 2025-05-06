package ObserverPattern.observer;

import ObserverPattern.observable.StocksObservable;

public class MobileAlertObserverImpl implements  NotificationAlertObserver{

    String username;
    StocksObservable observable;

    public  MobileAlertObserverImpl(String username , StocksObservable observable){

        this.username = username;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMsgOnMobile(username , "hurry");
    }

    public void  sendMsgOnMobile(String username , String msg){
        System.out.println("mesage  sent to mobile" + username);
    }
}
