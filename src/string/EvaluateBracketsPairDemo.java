package string;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * You are given a string s that contains some bracket pairs, with each pair containing a non-empty key.
 *
 * For example, in the string "(name)is(age)yearsold", there are two bracket pairs that contain the keys "name" and "age".
 * You know the values of a wide range of keys. This is represented by a 2D string array knowledge where each knowledge[i] = [keyi, valuei] indicates that key keyi has a value of valuei.
 *
 * You are tasked to evaluate all of the bracket pairs. When you evaluate a bracket pair that contains some key keyi, you will:
 *
 * Replace keyi and the bracket pair with the key's corresponding valuei.
 * If you do not know the value of the key, you will replace keyi and the bracket pair with a question mark "?" (without the quotation marks).
 * Each key will appear at most once in your knowledge. There will not be any nested brackets in s.
 *
 * Return the resulting string after evaluating all of the bracket pairs.
 *
 * Input: s = "(name)is(age)yearsold", knowledge = [["name","bob"],["age","two"]]
 * Output: "bobistwoyearsold"
 * Explanation:
 * The key "name" has a value of "bob", so replace "(name)" with "bob".
 * The key "age" has a value of "two", so replace "(age)" with "two".
 */
public class EvaluateBracketsPairDemo {

    public static void main(String[] args) {
        List<List<String>> knowledge = new ArrayList<>();
        List temp = new ArrayList<>();
        temp.add("name");
        temp.add("bob");
        knowledge.add(temp);
        temp = new ArrayList<>();
        temp.add("age");
        temp.add("two");
        knowledge.add(temp);

        String s  = "(name)is(age)yearsold";

        String response = evaluate(s, knowledge);
        System.out.println("Response - "+response);

        s = "hi(name)";
        temp = new ArrayList<>();
        temp.add("a");
        temp.add("b");
        knowledge = new ArrayList<>();
        knowledge.add(temp);
        response = evaluate(s, knowledge);
        System.out.println("Response - "+response);
    }
    public static String evaluate(String s, List<List<String>> knowledge) {

        Map<String, String> knowledgeMap = new HashMap<>();
        knowledge.forEach(rec->{
            knowledgeMap.put(rec.get(0), rec.get(1));
        });

        StringBuilder reponse= new StringBuilder();
        int index = 0 ;

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i)=='(')
            {
                reponse.append(s.substring(index, i));
                index=i+1;
            }
            else if (s.charAt(i)==')')
            {
                reponse.append(knowledgeMap.getOrDefault(s.substring(index, i), "?"));
                index=i+1;
            }
        }
        reponse.append(s.substring(index));
        return reponse.toString();
    }

}

class WordDictionary {

    HashSet<String> wordDictionary;
    public WordDictionary() {
        wordDictionary = new HashSet<>();
    }

    public void addWord(String word) {
        wordDictionary.add(word);
    }

    public boolean search(String word) {
        return wordDictionary.stream().filter(rec->rec.matches(word)).findAny().isPresent();
    }
}