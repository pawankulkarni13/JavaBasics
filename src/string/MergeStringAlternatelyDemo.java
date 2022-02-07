package string;

public class MergeStringAlternatelyDemo {
    public static void main(String[] args) {

        String word1 = "abc", word2 = "pqr";

        System.out.println(mergeAlternately(word1, word2));
        word1 = "ab";
        word2 = "pqrs";
        System.out.println(mergeAlternately(word1, word2));
        word1 = "abcd";
        word2 = "pq";
            System.out.println(mergeAlternately(word1, word2));
    }
    private static String mergeAlternately(String word1, String word2) {

        StringBuffer sb = new StringBuffer();
        int maxLength = Math.max(word1.length(), word2.length());

        for(int i = 0;i<maxLength;i++){
            if(i < word1.length())
                sb.append(word1.charAt(i));

            if(i < word2.length())
                sb.append(word2.charAt(i));
        }
        return sb.toString();
    }
}
