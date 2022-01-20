package programs;

public class ReverseInteger {

    public static void main(String[] args) {

        int value = 0;

        int result = reverseInteger(value);

        System.out.println("Reverse of "+ value + " is --> "+result);

        value = -912349;

        result = reverseInteger(value);

        System.out.println("Reverse of "+ value + " is --> "+result);

    }

    private static int reverseInteger(int value) {
//-1234-->1234
        boolean isNegative = Boolean.FALSE;
        if(value<0){
            isNegative = Boolean.TRUE;
            value = value * -1;
        }

        int lastValue = 0;
        int resultInt = 0;
//1234
        while(value>=1){
            lastValue = value %10;
            resultInt = (resultInt *10) + lastValue;
            value = value/10;
        }

        if(isNegative)
            resultInt = resultInt * -1;

        return resultInt;
    }


}
