package pyramid;

public class NumericPyramidDemo {
    public static void main(String[] args) {
        System.out.println("Press control+c to Exit");
        for(int i=0;i<100;i++){
            for(int j=0;j<i;j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
