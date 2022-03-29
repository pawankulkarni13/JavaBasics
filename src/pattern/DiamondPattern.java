package pattern;

/*
n=4
********
***  ***
**    **
*      *
*      *
**    **
***  ***
********
 */

public class DiamondPattern {

    public static void main(String[] args) {

        int rows=14;
        int j;
        int i=1;
        while(i<=rows){
            j=i;
            while(j<=rows){
                System.out.print("*");//print star
                j++;
            }
            j=1;
            while(j<=(2*i-2)){
                System.out.print(" ");//print space
                j++;
            }
            j=i;
            while(j<=rows){
                System.out.print("*");//print star
                j++;
            }
            System.out.print("\n");
            i++;
        }
        //loop for printing lower half part  of the pattern
        i=1;
        while(i<=rows){
            j=1;
            while(j<=i){
                System.out.print("*");//print star

                j++;
            }
            j=(2*i-2);
            while( j<(2*rows-2)){
                System.out.print(" ");//print space
                j++;
            }
            j=1;
            while(j<=i){
                System.out.print("*");
                j++;
            }
            System.out.print("\n");//move to next line
            i++;
        }
    }


}
