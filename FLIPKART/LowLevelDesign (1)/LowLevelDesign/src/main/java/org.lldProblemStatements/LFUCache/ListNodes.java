package main.java.org.lldProblemStatements.LFUCache;

public class ListNodes {
    private int size;
    public CacheNode head;
    public CacheNode tail;

    public ListNodes() {
        this.size = 0;
        this.head = new CacheNode("-1","-1");
        this.tail = new CacheNode("-1","-1");
        this.head.next = tail;
        this.tail.prev = head;
    }

    public void removeNode(CacheNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public void pushFront(CacheNode node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    public int size(){
        return this.size;
    }
}
