package string;

public class NonRepeatingCharacterInStringDemo {
    public static void main(String[] args) {
        String s = "zxvczbtxyzvy";
        System.out.println(s.charAt(findNonRepeatingChar(s)));
        System.out.println(s.charAt(alternateMethod(s)));
    }

    private static int findNonRepeatingChar(String s) {
        char count[] = new char[256];
        for (int j = 0; j < s.length(); j++)
            count[s.charAt(j)]++;

        int index = -1, i;

        for (i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)] == 1) {
                index = i;
                break;
            }
        }

        return index;
    }
     static int alternateMethod(String s){
        boolean flag = false;
        int index = -1;

        for (int i = 0; i < s.length(); i++) {

            int occurence = s.length() - s.replace(Character.toString(s.charAt(i)), "").length();

            if (occurence == 1) {
                flag = true;
                index = i;
                break;
            }
        }
        if(flag) {
            return index;
        }else {
            return -1;
        }
    }
}
