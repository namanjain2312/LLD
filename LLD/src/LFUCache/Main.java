package LFUCache;

public class Main {
    public static void main(String[] args) {
        Cache<Integer, String> cache = CacheFactory.createLRUCache(2);

        cache.put(1, "One");
        cache.put(2, "Two");
        System.out.println(cache.get(1)); // One
        cache.put(3, "Three"); // Evicts key 2
        System.out.println(cache.get(2)); // null
        System.out.println(cache.get(3)); // Three
    }
}
