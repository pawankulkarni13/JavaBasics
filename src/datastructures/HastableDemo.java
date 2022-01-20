package datastructures;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

public class HastableDemo {

    public static void main(String[] args) {

        Map map = new Hashtable();
        map.put("","pawan");
        map.put("1","Ibm");
        map.put("1","test");
//        map.put("1",null);    -- NPE
//        map.put(null,"test on null");  -- NPE

        System.out.println(map);
        System.out.println(map.get(""));

        String p = "pawan";

        char [] ch = p.toCharArray();
        Arrays.sort(ch);


        System.out.println(ch);

    }
}
