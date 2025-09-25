package main.java.org.lldProblemStatements.multiThreadedPubSubModel;

public class Subscriber implements Runnable{
    private final String name;
    private final MessageBroker broker;
    private final MessageQueue queue;

    public Subscriber(MessageBroker broker, String subscriberName,String topicName){
        this.name = subscriberName;
        this.broker = broker;
        this.queue = broker.getMessageQueue(topicName);
    }

    @Override
    public void run(){
        while(broker.isRunning()){
            String message = queue.subscribe();
            if(message!=null){
                System.out.println("Subscriber picked the message: "+message+" from thread "+Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Subscriber failed with error: "+e.getMessage());
                }
            }
        }
    }
}
