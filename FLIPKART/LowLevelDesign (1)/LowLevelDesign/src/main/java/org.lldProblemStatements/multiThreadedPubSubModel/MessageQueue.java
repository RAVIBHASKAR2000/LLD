package main.java.org.lldProblemStatements.multiThreadedPubSubModel;

import java.util.*;
import java.util.concurrent.*;

public interface MessageQueue{
    void publish(String message);
    String subscribe();
}

class MessageQueueWithBlockingQueue implements MessageQueue{
    private BlockingQueue<String> queue;

    public MessageQueueWithBlockingQueue(){
        this.queue = new LinkedBlockingQueue<>();
    }

    @Override
    public void publish(String message){
        queue.offer(message);
    }


    @Override
    public String subscribe() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class MessageQueueWithObjectLock implements MessageQueue{
    private Queue<String> queue;
    private Object lock = new Object();
    public MessageQueueWithObjectLock(){
        this.queue = new LinkedList<>();
    }

    @Override
    public void publish(String message){
        synchronized (lock){
            queue.add(message);
            lock.notify();
        }
    }

    @Override
    public String subscribe(){
        String message;
        synchronized(lock){
            if(queue.isEmpty()){
                System.out.println("Current thread "+ Thread.currentThread().getName()+" is waiting");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println("Something went wrong");
                }
            }
            message = queue.poll();
        }

        return message;
    }
}