package  LFUCache.src;

public interface LFUCacheInterface<K,V> {
    void put(K key, V value);

    V get(K key);
}
