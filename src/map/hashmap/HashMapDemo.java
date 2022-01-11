package map.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {

        Map<String, String> hashMap = new HashMap();

        hashMap.put(null, "Null Value");
        hashMap.put("", "Empty String Value");
        hashMap.put(null, "Null Value 2"); //Exception ? Nooo
        hashMap.put("FirstName", "Pawan");
        hashMap.put("LastName", "Kulkarni");


        System.out.println(hashMap.entrySet());

        //Would This throw a Null Pointer Exception ? Na
        System.out.println("Null Key , Value - " + hashMap.get(null));
        System.out.println("Empty String Key , Value  - " + hashMap.get(""));

        //Would This throw a Null Pointer Exception ? Nooooo
        Object nullObj = null;
        System.out.println("Null Key , Value- " + hashMap.get(nullObj));

    }
}
