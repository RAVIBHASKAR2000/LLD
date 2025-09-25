package main.java.org.lldProblemStatements.LFUCache;

import java.util.*;

public class LFUCache implements Cache{
    private final int maxCacheSize;
    private int leastFreq;
    private int currentCacheSize;

    HashMap<String, CacheNode> keyNodeMap;
    HashMap<Integer, ListNodes> freqListMap;

    public LFUCache(int capacity) {
        this.maxCacheSize = capacity;
        this.leastFreq = -1;
        this.currentCacheSize = 0;
        this.keyNodeMap = new HashMap<>();
        this.freqListMap = new HashMap<>();
    }

    void updateNodeFrequency(CacheNode node){
        freqListMap.remove(node.curr);

        if(freqListMap.get(node.curr).size()==0 && node.curr == leastFreq){
            leastFreq++;
        }

        node.curr++;
        ListNodes newList;
        if(freqListMap.containsKey(node.curr)){
            newList = freqListMap.get(node.curr);
            newList.pushFront(node);
        }
        else{
            newList = new ListNodes();
            newList.pushFront(node);
        }

        freqListMap.put(node.curr,newList);
    }

    @Override
    public void put(String key, String value){
        if(keyNodeMap.containsKey(key)){
            CacheNode currNode = keyNodeMap.get(key);
            currNode.value = value;

            updateNodeFrequency(currNode);
        }
        else{
            if(maxCacheSize == currentCacheSize){
                ListNodes currList = freqListMap.get(leastFreq);
                keyNodeMap.remove(currList.tail.prev.key);
                currList.removeNode(currList.tail.prev);
                currentCacheSize--;
            }

            currentCacheSize++;
            leastFreq = 1;

            CacheNode currNode = new CacheNode(key,value);

            ListNodes currList;
            if(freqListMap.containsKey(leastFreq)){
                currList = freqListMap.get(leastFreq);
                currList.pushFront(currNode);
            }
            else{
                currList = new ListNodes();
                currList.pushFront(currNode);
            }

            keyNodeMap.put(key,currNode);
            freqListMap.put(leastFreq,currList);
        }
    }

    @Override
    public String get(String key){
        String res = "-1";
        if(keyNodeMap.containsKey(key)){
            CacheNode currNode = keyNodeMap.get(key);
            res = currNode.value;

            updateNodeFrequency(currNode);
        }

        return res;
    }
}

