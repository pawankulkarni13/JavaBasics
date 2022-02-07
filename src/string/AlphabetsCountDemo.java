package string;

import java.util.HashMap;
import java.util.Map;

public class AlphabetsCountDemo {

    public static void main(String[] args) {

        String s = "PawanPawan";
        Map<Character, Integer> sMap = new HashMap<>();

        for(int i =0;i<s.length();i++){

            if(sMap.containsKey(s.charAt(i))){
                sMap.put(s.charAt(i), sMap.get(s.charAt(i))+1);
            }else{
                sMap.put(s.charAt(i), 1);
            }
        }
        System.out.println(sMap);
    }
}
