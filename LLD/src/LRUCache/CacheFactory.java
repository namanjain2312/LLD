package LRUCache;

public class CacheFactory {
    public static <K, V> Cache<K, V> createLRUCache(int capacity) {
        EvictionPolicy<K, V> policy = new LRUCachePolicy<>(capacity);
        return new Cache<>(policy);
    }
}
