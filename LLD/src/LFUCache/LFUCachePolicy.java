package LFUCache;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LFUCachePolicy<K, V> implements EvictionPolicy<K, V> {

    private final int capacity;
    private int minFreq;

    private final Map<K, Node<K, V>> map;
    private final Map<Integer, Node<K, V>[]> freqMap;


    public LFUCachePolicy(int capacity) {
        this.capacity = capacity;
        this.map = new ConcurrentHashMap<>();
        this.freqMap = new ConcurrentHashMap<>();
        this.minFreq = 0;
    }

    @Override
    public V get(K key) {
        synchronized (this) {
            if (!map.containsKey(key)) return null;

            Node<K, V> node = map.get(key);
            updateFrequency(node);
            return node.value;
        }
    }

    @Override
    public void put(K key, V value) {
        synchronized (this) {
            if (capacity == 0) return;

            if (map.containsKey(key)) {
                Node<K, V> node = map.get(key);
                node.value = value;
                updateFrequency(node);
                return;
            }

            if (map.size() == capacity) {
                evictLFU();
            }

            Node<K, V> newNode = new Node<>(key, value);
            newNode.freq = 1;
            map.put(key, newNode);
            insertToFreqList(1, newNode);
            minFreq = 1;
        }
    }

    private void updateFrequency(Node<K, V> node) {
        int oldFreq = node.freq;
        removeFromFreqList(oldFreq, node);

        if (oldFreq == minFreq && isFreqListEmpty(oldFreq)) {
            minFreq++;
        }

        node.freq++;
        insertToFreqList(node.freq, node);
    }

    private void evictLFU() {
        Node<K, V>[] list = freqMap.get(minFreq);
        Node<K, V> tail = list[1];

        if (tail == null) return;

        Node<K, V> toRemove = tail.prev;
        removeFromFreqList(minFreq, toRemove);
        map.remove(toRemove.key);
    }

    private void insertToFreqList(int freq, Node<K, V> node) {
        Node<K, V>[] list = freqMap.get(freq);

        if (list == null) {
            Node<K, V> head = new Node<>(null, null);
            Node<K, V> tail = new Node<>(null, null);
            head.next = tail;
            tail.prev = head;
            list = new Node[]{head, tail};
            freqMap.put(freq, list);
        }

        Node<K, V> head = list[0];
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeFromFreqList(int freq, Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private boolean isFreqListEmpty(int freq) {
        Node<K, V>[] list = freqMap.get(freq);
        return list[0].next == list[1]; // head.next == tail
    }


}