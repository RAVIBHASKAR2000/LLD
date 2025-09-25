package main.java.org.lldProblemStatements.LFUCache;

public class Client {
    public static void main(String[] args){
        Cache cache = new LFUCache(5);

        cache.put("Name","Akshay");
        cache.put("Address","Sri Krishna Ventures");
        cache.put("Phone Number","8008280284");
        System.out.println(cache.get("Name"));
        System.out.println(cache.get("Current Company"));
    }
}
