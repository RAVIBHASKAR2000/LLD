package main.java.org.lldProblemStatements.LFUCache;

public interface Cache {
    void put(String key, String value);
    String get(String key);
}
