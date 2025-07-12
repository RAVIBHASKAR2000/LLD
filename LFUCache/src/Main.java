package LFUCache.src;

public class Main {
    public static void main(String[] args) {

        LFUCache cache = new LFUCache(2);

        cache.put(1, 10);  // freq 1
        cache.put(2, 20);  // freq 1
        System.out.println(cache.get(1)); // 10 -> freq 2
        cache.put(3, 30);  // evict key 2
        System.out.println(cache.get(2)); // -1
        System.out.println(cache.get(3)); // 30
        System.out.println(cache.get(1)); // 10
    }
}