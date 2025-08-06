package LFUCache;

import LRUCache.LRUCachePolicy;

public class CacheFactory {
    public static <K, V> Cache<K, V> createLFUCache(int capacity) {
        EvictionPolicy<K, V> policy = new LFUCachePolicy<>(capacity);
        return new Cache<>(policy);
    }
}
