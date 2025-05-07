public interface LRUCacheInterface<K,V> {
    public V get(K key);

    void put(K key, V value);
}
