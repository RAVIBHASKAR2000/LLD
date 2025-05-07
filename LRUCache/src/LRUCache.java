import java.util.HashMap;

public class LRUCache <K,V> implements LRUCacheInterface<K,V> {
    private class Node{
        K key;
        V val;
        Node left;
        Node right;
        Node(K key, V val){
            this.key = key;
            this.val = val;
        }
    }


    private final int capacity;

    private final HashMap<K, Node> hmap;
    private final Node head , tail;

    public  LRUCache(int capacity){
        this.capacity = capacity;

        hmap = new HashMap<>();
        head = new Node(null, null);
        tail = new Node(null, null);

        head.right = tail;
        tail.left = head;



    }

    @Override
    public V get(K key) {
        if (!hmap.containsKey(key)) return null;
        Node node = hmap.get(key);
        remove(node);
        insertToFront(node);
        return node.val;
    }

    @Override
    public void put(K key, V value) {
        if (hmap.containsKey(key)) {
            remove(hmap.get(key));
        }
        if (hmap.size() == capacity) {
            hmap.remove(tail.left.key);
            remove(tail.left);
        }
        Node node = new Node(key, value);
        insertToFront(node);
        hmap.put(key, node);
    }

    private void remove(Node node) {
        node.left.right = node.right;
        node.right.left = node.left;
    }

    private void insertToFront(Node node) {
        node.right = head.right;
        node.left = head;
        head.right.left = node;
        head.right = node;
    }
}
