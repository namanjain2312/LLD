package LFUCache;

public class Cache <K,V>{
    private final EvictionPolicy<K, V> evictionPolicy;

    public Cache(EvictionPolicy<K, V> policy) {
        this.evictionPolicy = policy;
    }

    public V get(K key) {
        return evictionPolicy.get(key);
    }

    public void put(K key, V value) {
        evictionPolicy.put(key, value);
    }

}
