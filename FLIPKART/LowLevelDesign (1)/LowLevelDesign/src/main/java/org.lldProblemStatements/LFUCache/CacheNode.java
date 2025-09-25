package main.java.org.lldProblemStatements.LFUCache;

public class CacheNode {
    public String key;
    public String value;
    public int curr;
    public CacheNode next;
    public CacheNode prev;

    public CacheNode(String key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
        this.curr = 1;
    }
}
