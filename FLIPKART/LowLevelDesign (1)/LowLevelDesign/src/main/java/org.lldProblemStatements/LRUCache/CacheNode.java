package main.java.org.lldProblemStatements.LRUCache;

public class CacheNode {
    private String key;
    private String value;
    private CacheNode next;
    private CacheNode prev;

    public CacheNode(String key, String value){
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public CacheNode getNext() {
        return next;
    }

    public void setNext(CacheNode next) {
        this.next = next;
    }

    public CacheNode getPrev() {
        return prev;
    }

    public void setPrev(CacheNode prev) {
        this.prev = prev;
    }
}
