package main.java.org.lldProblemStatements.PubSubModel;

public class Subscriber {
    public void consumeMessage(Message message){
        System.out.println(message.getMessage());
    }
}
