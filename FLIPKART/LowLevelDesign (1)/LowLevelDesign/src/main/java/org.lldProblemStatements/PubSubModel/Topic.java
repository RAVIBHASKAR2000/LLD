package main.java.org.lldProblemStatements.PubSubModel;

import java.util.*;

public class Topic {
    private List<Subscriber> subs;

    public Topic() {
        this.subs = new ArrayList<>();
    }

    public void subscribe(Subscriber sub){
        subs.add(sub);
    }

    public void unSubscribe(Subscriber sub){
        subs.remove(sub);
    }

    public void publishMessage(Message message){
        for(Subscriber sub: subs){
            sub.consumeMessage(message);
        }
    }
}
