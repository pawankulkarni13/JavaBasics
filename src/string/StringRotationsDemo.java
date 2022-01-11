package string;

public class StringRotationsDemo {

    static boolean isStringRotated(String s1, String s2){
        if(s1.length() != s2.length())
            return false;

        if((s1+s2).indexOf(s2) != -1){
            //Which means s2 is not present in bigger string and is not rotated.
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("ACCD and CDCA - " + isStringRotated("ACCD", "CDCA"));
    }

}
