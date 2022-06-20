package string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharDemo {
    public static void main(String[] args) {

        String s = "abcabcbb";

        System.out.println("lengthOfLongestSubstring - "+lengthOfLongestSubstring(s));
        s = "bbbbb";
        System.out.println("lengthOfLongestSubstring - "+lengthOfLongestSubstring(s));
        s = "pwwkew";
        System.out.println("lengthOfLongestSubstring - "+lengthOfLongestSubstring(s));
        s = "abcdeart";
        System.out.println("lengthOfLongestSubstring - "+lengthOfLongestSubstring(s));
    }

    private static int lengthOfLongestSubstring(String s) {
        if(s == null || s.equals(""))
            return 0;
        int count = 0;
        for(int i=0;i<s.length();i++){

            int tempCounter = 0;
            Set charSet = new HashSet();
            char ch = s.charAt(i);
            charSet.add(ch);
            int j=i+1;
            while(j < s.length()){
                if(charSet.add(s.charAt(j))){
                    tempCounter ++;
                }else{
                    break;
                }
                j++;
            }
            if(tempCounter > count){
                count=tempCounter;
            }

        }
        return count+1;
    }
}
