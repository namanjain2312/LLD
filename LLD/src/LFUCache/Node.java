package LFUCache;

public class Node<K,V> {
    K key;
    V value;
    Node<K,V> prev,next;
    int freq;  // For LFU

    public Node(K key, V value)
    {
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}
