package programs;

public class IntegersWithOppositeSignDemo {
    //Find if two integers have opposite signs
    public static void main(String[] args) {
        System.out.println(findIfOppNumbers(100, -100));
        System.out.println(findIfOppNumbers(10, -100));
    }

    private static boolean findIfOppNumbers(int i, int j) {
        if(i<0){
            i = i * -1;
        }else if(j<0){
            j = j * -1;
        }
        if(i == j)
            return true;
        return false;
    }
}
