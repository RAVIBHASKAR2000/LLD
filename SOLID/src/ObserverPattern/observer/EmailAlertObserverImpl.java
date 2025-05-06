package ObserverPattern.observer;

import ObserverPattern.observable.StocksObservable;

public class EmailAlertObserverImpl implements  NotificationAlertObserver{
    String emailId;
    StocksObservable observable;

    public  EmailAlertObserverImpl(String emailId , StocksObservable observable){

        this.emailId = emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMail(emailId , "hurry");
    }

    public void  sendMail(String emailId , String msg){
        System.out.println("Mail sent to" +emailId);
    }
}
