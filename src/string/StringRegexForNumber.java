package string;

public class StringRegexForNumber {

    public static void main(String[] args) {
        String regex = "[0-9]+"; // Can also use - "\\d+";
        String no = "23343453";
        System.out.println("String is Number ?: "+ no +" - "+ no.matches(regex));
        no = "A23343453";
        System.out.println("String is Number ?: "+ no +" - "+ no.matches(regex));
    }
}
