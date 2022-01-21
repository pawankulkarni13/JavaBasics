package string;

public class CompressStringwithOccurenceDemo {

// Problem statement - Compress the string by encoding it with number of occurences
// Input - aabbbcd
// output 2a3b1c1d -> aabbbcd

// inout aaaaabcaa
// output 5a1b1c2a

    // Constraint - Return original string, if the compressed one is growing bigger immidiately

    public static void main(String args[]) throws Exception {
        String str = "aabbbcd";
        String resp = compressStrOcc(str);
        System.out.println(resp);

        str = "aaaaabcaa";
        resp = compressStrOcc(str);
        System.out.println(resp);
    }

    static String compressStrOcc(String s) {

        // aabbbcd
        // output 2a3b1c1d -> aabbbcd

        StringBuilder finalString = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            char ch = s.charAt(i);

            int j = i + 1;
            while (j < s.length()) {
                if (s.charAt(j) == ch) {
                    count++;
                } else {
                    break;
                }
                j++;
            }
            i=j-1;
            finalString.append("" + count + ch);
            if(finalString.toString().length() > s.length()){
                return s;
            }
        }
        return finalString.toString();

    }

}
