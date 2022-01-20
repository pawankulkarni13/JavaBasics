package caching;

import java.util.LinkedHashMap;
import java.util.Map;

//Least Recently Used (LRU) cache.
public class LRUCache <K,V> extends LinkedHashMap<K,V> {
    int size;
    LRUCache(int capacity){
        super(16, 0.75f, true); //true is for access order instead of insertion order
        this.size = capacity;
    }
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > size;
    }
}
