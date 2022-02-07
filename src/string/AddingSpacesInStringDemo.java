package string;

public class AddingSpacesInStringDemo {
    public static void main(String[] args) {

        String s = "LeetcodeHelpsMeLearn";
        int [] spaces = {8,13,15};
        System.out.println(addSpaces(s, spaces));
    }
    private static String addSpaces(String s, int[] spaces) {

        StringBuilder ans = new StringBuilder();
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (j < spaces.length && spaces[j] == i) {
                ans.append(' ');
                ++j;
            }
            ans.append(s.charAt(i));
        }
        return ans.toString();

    }
}
