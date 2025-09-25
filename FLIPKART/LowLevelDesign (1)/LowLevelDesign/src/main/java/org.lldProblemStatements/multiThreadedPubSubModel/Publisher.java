package main.java.org.lldProblemStatements.multiThreadedPubSubModel;

public class Publisher implements Runnable {
    private final String name;
    private final MessageQueue queue;
    private final MessageBroker broker;

    public Publisher(MessageBroker broker, String publisherName, String topicName){
        this.name = publisherName;
        this.broker = broker;
        this.queue = broker.getMessageQueue(topicName);
    }

    private void publish(String message){
        System.out.println("Published message "+ message+ " to the message queue!");
        this.queue.publish(message);
    }

    @Override
    public void run(){
        for(int i=0;i<5;i++){
            String message = "Message number "+i+" from thread "+Thread.currentThread().getName();
            this.publish(message);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Publisher failed with error: "+e.getMessage());
            }
        }
    }
}
