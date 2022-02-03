package programs;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRomanNumberDemo {
    public static void main(String[] args) {
        int num = 3;
        System.out.println(num + " = " + intToRoman(num));
    }

    private static String intToRoman(int num) {

        Map<String, Integer> symbolData = collectSymbolData();

        //I can be placed before V (5) and X (10) to make 4 and 9.
        //X can be placed before L (50) and C (100) to make 40 and 90.
        //C can be placed before D (500) and M (1000) to make 400 and 900.

        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }

        return null;
    }

    private static Map<String, Integer> collectSymbolData() {

        //Symbol       Value
        //I             1
        //V             5
        //X             10
        //L             50
        //C             100
        //D             500
        //M             1000
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        return map;
    }
}
