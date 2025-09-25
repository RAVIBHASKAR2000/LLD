package main.java.org.lldProblemStatements.PubSubModel;

import java.util.*;

public class Publisher {
    private List<Topic> topics;

    public Publisher() {
        this.topics = new ArrayList<>();
    }

    public void register(Topic topic){
        topics.add(topic);
    }

    public void unRegister(Topic topic){
        topics.remove(topic);
    }

    public void publish(Message message){
        for(Topic topic: topics){
            topic.publishMessage(message);
        }
    }
}
