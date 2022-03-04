package string;

public class NumberOfValidWordsInSentenceDemo {
    public static void main(String[] args) {
        String sentence = "cat and  dog";
        System.out.println("Should be 3 - "+countValidWords(sentence));
        sentence = "!this  1-s b8d!";
        System.out.println("Should be 0 - "+countValidWords(sentence));
        sentence = "alice and  bob are playing stone-game10";
        System.out.println("Should be 5 - "+countValidWords(sentence));

    }

    private static int countValidWords(String sentence) {
        int validCount = 0;
        String[] words = sentence.split("\\s+");

        String regex = "^([a-z]+(-?[a-z]+)?)?(!|\\.|,)?$";
        String r2 = "[^0-9]+";
        for (String s : words) {
            if (s.matches(regex) && s.matches(r2)) {
                validCount++;
                //System.out.println(s);
            }
        }

        boolean [] b = new boolean[words.length];
        return validCount;

    }
}
