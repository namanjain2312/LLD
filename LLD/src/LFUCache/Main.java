package LFUCache;

public class Main {
    public static void main(String[] args) {
        Cache<Integer, String> cache = CacheFactory.createLFUCache(2);

        cache.put(1, "One");  // freq(1) = 1
        cache.put(2, "Two");  // freq(2) = 1

        cache.get(1);         // freq(1) = 2

        cache.put(3, "Three"); // Evicts key 2 (lowest freq = 1)

        System.out.println(cache.get(1)); // One
        System.out.println(cache.get(2)); // null (evicted)
        System.out.println(cache.get(3)); // Three
    }
}