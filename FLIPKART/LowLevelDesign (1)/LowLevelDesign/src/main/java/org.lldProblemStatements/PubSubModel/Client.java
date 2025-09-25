package main.java.org.lldProblemStatements.PubSubModel;

public class Client {
    public static void main(String[] args){
        Publisher p1 = new Publisher();
        Publisher p2 = new Publisher();
        Publisher p3 = new Publisher();

        Topic t1 = new Topic();
        Topic t2 = new Topic();
        Topic t3 = new Topic();

        Subscriber sub1 = new Subscriber();
        Subscriber sub2 = new Subscriber();
        Subscriber sub3 = new Subscriber();

        p1.register(t1);
        p2.register(t2);

        t1.subscribe(sub1);
        t1.subscribe(sub2);

        t2.subscribe(sub3);

        p1.publish(new Message("Hello Subscribers!"));
        p2.publish(new Message("Hello Premium Subscribers!"));
    }
}
