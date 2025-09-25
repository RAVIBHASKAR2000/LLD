package main.java.org.lldProblemStatements.LRUCache;

import java.util.HashMap;

public class LRUCache implements Cache{
    private int cacheSize;
    private HashMap<String, CacheNode> cacheMap;
    private CacheNode head;
    private CacheNode tail;

    public LRUCache(int capacity){
        cacheSize = capacity;
        cacheMap = new HashMap<>();
        head = new CacheNode(null,null);
        tail = new CacheNode(null,null);
    }

    @Override
    public synchronized void put(String key, String value) {
        //create a new node

        // if the cache is empty
        if(cacheMap.size()==0){
            CacheNode currNode = new CacheNode(key,value);
            // set the head node's next to currNode
            head.setNext(currNode);
            // set the tail node's prev to currNode
            tail.setPrev(currNode);
            // set the currNode's prev to head
            currNode.setPrev(head);
            // set the currNode's next to head
            currNode.setNext(head);
            // add it in the hashMap
            cacheMap.put(key,currNode);
        }
        // cache is not empty
        else{
            // if the key already exist in the cache
            if(cacheMap.containsKey(key)){
                // remove it from that part in the linked list
                CacheNode currNode = cacheMap.get(key);
                currNode.getPrev().setNext(currNode.getNext());
                currNode.getNext().setPrev(currNode.getPrev());

                // add it next to head
                currNode.setNext(head.getNext());
                head.getNext().setPrev(currNode);
                head.setNext(currNode);
                currNode.setPrev(head);
            }
            // if key doesn't exist inside the cache
            else{
                CacheNode currNode = new CacheNode(key,value);

                // add the node next to the head
                currNode.setNext(head.getNext());
                head.getNext().setPrev(currNode);
                head.setNext(currNode);
                currNode.setPrev(head);

                cacheMap.put(key,currNode);
            }
        }

        // check if the size of the cache is full or not
        while(cacheMap.size()>this.cacheSize){
            cacheMap.remove(tail.getPrev().getKey());
            tail.setPrev(tail.getPrev().getPrev());
            tail.getPrev().getPrev().setNext(tail);
        }
    }

    @Override
    public synchronized String get(String key){
        // check if the value exists in the cacheMap
        if(cacheMap.containsKey(key)){
            CacheNode currNode = cacheMap.get(key);

            // reset the node to the starting of the cache
            currNode.getPrev().setNext(currNode.getNext());
            currNode.getNext().setPrev(currNode.getPrev());

            // add it next to head
            currNode.setNext(head.getNext());
            head.getNext().setPrev(currNode);
            head.setNext(currNode);
            currNode.setPrev(head);

            return currNode.getValue();
        }
        else{
            return "-1";
        }
    }
}
