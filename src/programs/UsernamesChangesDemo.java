package programs;

import java.util.ArrayList;
import java.util.List;

/**
 * There is a Specific Need for Changes in a List of Usernames. In a given List of Usernames — For Each Username — If the Username can be Modified and Moved Ahead in a Dictionary. The Allowed Modification is that Alphabets can change Positions in the Given Username.
 *
 * Example
 * usernames[] = {"Aba", "Cat"}
 *
 * "Aba" can be Changed to only "Baa" — Hence, It can Never Find a Place Ahead in the Dictionary. Hence, Output will be "NO". "Cat" can be Changed to "Act", "Atc", "Tca", "Tac", "Cta" and Definitely "Act" will Find a Place Before "Cat" in the Dictionary. Hence, Output will be "YES".
 *
 * [Function Description]
 * Complete the function possibleChanges in the Editor Below.
 *
 * possibleChanges has the Following Parameters:
 * String usernames[n]: An Array of User Names
 *
 * Returns String[n]: An Array with "YES" or "NO" Based on Feasibility
 * (Actual Question Says String Array, But Signature is List of Strings)
 *
 *
 * Constraints
 * • [No Special Constraints Exist, But Cannot Recall Exactly]
 *
 *
 * Input Format
 * "The First Line Contains an Integer, n, the Number of Elements in Usernames.",
 * "Each Line of the n Subsequent Lines (where 0 < i < n) contains a String usernames[i]."
 *
 * [Sample Case 0 — Sample Input For Custom Testing]
 * 5
 * Aba
 * Cat
 * Boby
 * Buba
 * Bapg
 * Sungi
 * Lapg
 * Acba
 *
 * Sample Output (Each Should Be on a Separate Line)
 * NO YES NO YES YES YES YES YES
 */
public class UsernamesChangesDemo {

    public static void main(String[] args) {

        List<String> usernames = new ArrayList<>();
        usernames.add("foo");
        usernames.add("bar");
        usernames.add("baz");

        System.out.println(usernames + " Possible Changes are - "+ possibleChanges(usernames));

    }

    private static List<String> possibleChanges(List<String> usernames) {

        List<String> possible = new ArrayList<>();
        boolean flag;

        for(String username: usernames){
            flag = false;
            String currName = username.toLowerCase();
            for(int i=0;i<currName.length();i++){

                int a = currName.charAt(i);
                for(int j=i+1;j<currName.length();j++){

                    int b = currName.charAt(j);
                    if(b<a){
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    possible.add("YES");
                    break;
                }
            }
            if(!flag)
                possible.add("NO");

        }
        return possible;
    }
}
