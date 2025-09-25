package main.java.org.lldProblemStatements.multiThreadedPubSubModel;

import java.util.concurrent.ConcurrentHashMap;

public class MessageBroker {
    private final ConcurrentHashMap<String, MessageQueue> topicMap;
    private volatile boolean isRunning;

    public MessageBroker(){
        topicMap = new ConcurrentHashMap<>();
        this.isRunning = true;
    }

    public void createNewTopic(String topicName){
        this.topicMap.putIfAbsent(topicName,new MessageQueueWithBlockingQueue());
    }

    public boolean isRunning(){return this.isRunning;}

    public void stop(){this.isRunning = false;}

    public MessageQueue getMessageQueue(String topicName){
        return this.topicMap.getOrDefault(topicName, null);
    }
}
