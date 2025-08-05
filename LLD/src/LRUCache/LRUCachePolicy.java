package LRUCache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCachePolicy<K,V> implements EvictionPolicy<K,V> {

    private final int capacity;
    private final Map<K, Node<K, V>> map;
    private final Node<K, V> head, tail;

    public LRUCachePolicy(int capacity) {
        this.capacity = capacity;
        this.map = new ConcurrentHashMap<>();

        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public V get(K key) {
        synchronized (this) {
            if (!map.containsKey(key)) return null;
            Node<K, V> node = map.get(key);
            remove(node);
            insertAtFront(node);
            return node.value;
        }
    }

    @Override
    public void put(K key, V value) {
        synchronized (this) {
            if (map.containsKey(key)) {
                remove(map.get(key));
            } else if (map.size() == capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }

            Node<K, V> newNode = new Node<>(key, value);
            insertAtFront(newNode);
            map.put(key, newNode);
        }
    }

    private void remove(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtFront(Node<K, V> node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
