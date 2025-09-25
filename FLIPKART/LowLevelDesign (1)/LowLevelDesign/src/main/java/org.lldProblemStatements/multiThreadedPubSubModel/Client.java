package main.java.org.lldProblemStatements.multiThreadedPubSubModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String []args) throws InterruptedException {
        MessageBroker broker = new MessageBroker();
        broker.createNewTopic("OrderUpdates");
        broker.createNewTopic("CartUpdates");


        Publisher orderUpdatePublisher = new Publisher(broker, "orderUpdatePublisher","OrderUpdates");
        Subscriber orderUpdateSubscriber = new Subscriber(broker,"orderUpdateSubscriber","OrderUpdates");


        Publisher cartUpdatePublisher = new Publisher(broker, "cartUpdatePublisher","CartUpdates");
        Subscriber cartUpdateSubscriber = new Subscriber(broker,"cartUpdateSubscriber","CartUpdates");

        ExecutorService executorService =  Executors.newFixedThreadPool(5);
        executorService.execute(orderUpdatePublisher);
        executorService.execute(orderUpdateSubscriber);
        executorService.execute(cartUpdatePublisher);
        executorService.execute(cartUpdateSubscriber);


        broker.stop();
        executorService.shutdown();
    }
}
