package programs;

import java.util.Arrays;

public class AnagramDemo {
    public static void main(String[] args) {

        System.out.println(isAnagram("Keep", "Peek"));
        System.out.println(isAnagram("Mother In Law", "Hitler Woman"));
    }

    public static boolean isAnagram(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[] arr1 = new int[256];
        int[] arr2 = new int[256];
        if (l1 != l2) {
            return false;
        }

        for (int i = 0; i < l1; i++) {
            arr1[s1.charAt(i)]++;
            arr2[s2.charAt(i)]++;
        }

        return Arrays.equals(arr1, arr2);
    }
}
