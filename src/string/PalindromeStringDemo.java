package string;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class PalindromeStringDemo {

    public static boolean isPalindrome(String str) {
        int left =0;
        int right = str.length()-1;
        str = str;

        while(left<=right){
            char leftChar = str.charAt(left);
            char rightChar = str.charAt(right);

            if(!(leftChar >= 'a' && leftChar <= 'z'))
                left++;
            else if((rightChar >= 'a' && rightChar<='z'))
                right--;
            else if(leftChar == rightChar) {
                left++;
                right++;
            }else
                return false;
        }
        return true;
    }

    @Test
    public void given_String_When_Is_Not_Palindrome_Then_Returns_False(){

        String s =sanitize("Madam, I'm ur Adam.");
        System.out.println(s);
        assertTrue(PalindromeStringDemo.isPalindrome(s));

    }

    private static String sanitize(String in) {
        String result = null;

        Pattern p = Pattern.compile("[^a-zA-Z0-9]+");
        Matcher m = p.matcher(in);
        result = m.replaceAll("");
        return result.toLowerCase();
    }
}
