package caching;

import java.util.ArrayList;
import java.util.List;

public class MultiLevelCache {
    static MultiLevelCache instance;
    private static LRUCache<Integer, LRUCache<Integer, Integer>> multiCache = null;

    private MultiLevelCache() {}

    public static synchronized MultiLevelCache getInstance(){
        if(instance == null) {
            instance = new MultiLevelCache();
            multiCache = new LRUCache<Integer, LRUCache<Integer, Integer>>(3);
            multiCache.put(10, new LRUCache<Integer, Integer>(30));
            //this size needs to be more so that all keys can go here without getting removed
            multiCache.put(20, new LRUCache<Integer, Integer>(3));
            multiCache.put(30, new LRUCache<Integer, Integer>(3));
        }
        return instance;
    }

    public int get(int key) {
        return multiCache.get(10).get(key);
        //we need to make sure LRU size for the lowest cache is really large so that all keys can be stored there
    }

    public void add(int key, int value) {
        List<Integer> levelList = getLevel(key);
        for(Integer keyList: levelList) {
            multiCache.get(keyList).put(key, value);
        }
    }

    private static List<Integer> getLevel(int key) {
        int modValue = key % 30;
        List<Integer> a = new ArrayList<>();
        if(modValue < 10) {a.add(10);}
        if(modValue >= 10 && modValue < 20) {a.add(20); a.add(10);}
        if(modValue >= 20 && modValue < 30) {a.add(30); a.add(20); a.add(10);}

        return a;
    }
}
