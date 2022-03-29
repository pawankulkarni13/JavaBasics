package datastructures;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

//ConcurrentNavigableMap is I
//ConcurrentSkipListMap is Class

public class ConcurrentSkipListMapDemo {
    public static void main(String[] args) {
        ConcurrentNavigableMap map = new ConcurrentSkipListMap();

        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");

        ConcurrentNavigableMap headMap = map.headMap("2");

        System.out.println("headMap" +headMap);
        System.out.println("map"+map);

        map.put("0", "zero");
        System.out.println("map"+map);
        System.out.println("headMap" + headMap);

    }
}
