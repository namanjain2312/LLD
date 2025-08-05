package LFUCache;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LFUCachePolicy<K, V> implements EvictionPolicy<K, V> {
    private final int capacity;
    private int minFreq;
    private final Map<K, Node<K, V>> map;
    private final Map<Integer, ConcurrentL<Node<K, V>>> freqMap;

    private final Map<Integer, Pair<Node<K, V>,Pair<Node<K,V>> freqMap; // where first pair is

    public LFUCachePolicy(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.map = new ConcurrentHashMap<>();
        this.freqMap = new ConcurrentHashMap<>();
    }

}