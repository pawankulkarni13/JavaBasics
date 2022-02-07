package string;

import java.util.*;

public class DifferenceBetweenStringDemo {
    public static void main(String[] args) {

        String s = "abcd";
        String t = "abcde";

        findTheDifference(s,t);
    }

    private static void findTheDifference(String s, String t) {

        List sSet = new ArrayList();
        List tSet = new ArrayList();
        for(int i = 0;i<s.length();i++){
            sSet.add(s.charAt(i));
        }

        for(int j = 0;j<t.length();j++){
            tSet.add(t.charAt(j));
        }
        tSet.removeAll(sSet);
    }
}
