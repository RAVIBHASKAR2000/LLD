
package  LFUCache.src;
import  java.util.*;

class LFUCache<K,V> implements LFUCacheInterface<K,V>{

    class Node {
        K key;
        V val;
        int freq;
        Node prev, next;

        Node(K key, V val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {
        Node head, tail;
        int size =0;

        DoublyLinkedList() {
            head = new Node(null, null); // dummy head
            tail = new Node(null, null); // dummy tail
            head.next = tail;
            tail.prev = head;
        }

        void addNode(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeTail() {
            if (size == 0) return null;
            Node toRemove = tail.prev;
            removeNode(toRemove);
            return toRemove;
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

    private final int capacity;
    private int minFreq;
    private final Map<K, Node> keyMap;
    private final Map<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public V get(K key) {
        if (!keyMap.containsKey(key)) return null;

        Node node = keyMap.get(key);
        update(node);
        return node.val;
    }

    public void put(K key, V value) {
        if (capacity == 0) return;

        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.val = value;
            update(node);
        } else {
            if (keyMap.size() >= capacity) {
                DoublyLinkedList list = freqMap.get(minFreq);
                Node toEvict = list.removeTail();
                keyMap.remove(toEvict.key);
            }

            Node newNode = new Node(key, value);
            keyMap.put(key, newNode);
            freqMap.computeIfAbsent(1, keyfreq -> new DoublyLinkedList()).addNode(newNode);
            minFreq = 1;
        }
    }

    private void update(Node node) {
        int freq = node.freq;
        DoublyLinkedList list = freqMap.get(freq);
        list.removeNode(node);

        if (freq == minFreq && list.isEmpty()) {
            minFreq++;
        }

        node.freq++;
        freqMap.computeIfAbsent(node.freq, keyfreq -> new DoublyLinkedList()).addNode(node);
    }
}


/*


| Operation  | freqMap                                          | minFreq |
| ---------- | ------------------------------------------------ | ------- |
| put(1, 10) | {1: \[1]}                                        | 1       |
| put(2, 20) | {1: \[1, 2]}                                     | 1       |
| get(1)     | {1: \[2], 2: \[1]}                               | 1       |
| put(3, 30) | evict 2 (least freq), add 3 → {1: \[3], 2: \[1]} | 1       |

 */