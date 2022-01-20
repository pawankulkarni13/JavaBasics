package caching;

public class CacheDemo {
    public static void main(String[] args) {
        MultiLevelCache cache = MultiLevelCache.getInstance();
        cache.add(1,1);
        cache.add(2,2);
        cache.add(3,3);
        System.out.println(cache.get(2));
        cache.add(4,4);
        cache.add(29,29);
        cache.add(35,35);
        System.out.println(cache.get(35));
    }
}
