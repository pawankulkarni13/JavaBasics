package design;

import java.util.HashSet;

/**
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 *
 * Implement the WordDictionary class:
 *
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
 * word may contain dots '.' where dots can be matched with any letter.
 *
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 *
 * Explanation
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 */
public class DesignWordAddSearchDSDemo {

    public static void main(String[] args) {

        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println("wordDictionary.search(\"pad\")" + wordDictionary.search("pad")); // return False
        System.out.println("wordDictionary.search(\"bad\")" + wordDictionary.search("bad")); // return True
        System.out.println("wordDictionary.search(\".ad\")" + wordDictionary.search(".ad")); // return True
        System.out.println("wordDictionary.search(\"b..\")" + wordDictionary.search("b..")); // return True

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
        if(wordDictionary.contains(word))
            return true;

        char[] wd = word.toCharArray();
        boolean flag =false;
        for(String s : wordDictionary){
            char[] ca = s.toCharArray();
            if(ca.length!=wd.length){
                continue;
            }
            for(int j =0;j<wd.length;j++){
                if(wd[j]=='.'||ca[j]=='.'|ca[j]==wd[j]){
                    flag = true;
                }
                else{
                    flag = false;
                    break;
                }
            }
            if(flag==true){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */