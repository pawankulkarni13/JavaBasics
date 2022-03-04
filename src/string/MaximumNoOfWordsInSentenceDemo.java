package string;

/**
 * A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
 *
 * You are given an array of strings sentences, where each sentences[i] represents a single sentence.
 *
 * Return the maximum number of words that appear in a single sentence.
 */

public class MaximumNoOfWordsInSentenceDemo {

    public static void main(String[] args) {

        String [] sentences = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        System.out.println(mostWordsFound(sentences));
        sentences = new String[]{"please wait", "continue to fight", "continue to win"};
        System.out.println(mostWordsFound(sentences));
    }

    private static int mostWordsFound(String[] sentences) {
        int maxNoWords = 0;
        for(String s: sentences){

            String [] words = s.split(" ");
            int len = words.length;
            if(len > maxNoWords)
                maxNoWords = len;
        }
        return maxNoWords;
    }
}
