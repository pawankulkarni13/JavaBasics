package string;

public class StringBufferDemo {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        StringBuilder sb1= new StringBuilder();

        sb.subSequence(0, sb.lastIndexOf(" "));
//        sb.append(0,"One");

    }
}
