package programs;

public class ReverseNumberDemo {

    public static void main(String[] args) {
        int no = 1534236469;
        int reverse = reverse(no);
        System.out.println("Reverse - " + reverse);
    }

    public static int reverse(int x) {
        long reversed =0;
        int flag = 0;
        if(x<0)
            flag =1;
        x = Math.abs(x);
        while(x!=0){
            reversed = (reversed*10) + x%10;
            x/=10;
            if(reversed < Integer.MIN_VALUE || reversed > Integer.MAX_VALUE)
                return 0;
        }
        if(flag ==1)
            reversed *= -1;
        return (int)reversed;

//        int n=x;
//        long num=0;
//        boolean negative=false;
//        if(n<0)
//        {
//            negative =true;
//            n=-1*n;
//        }
//        while(n>0)
//        {
//            int r=n%10;
//            num=(num*10)+r*1;
//            n=n/10;
//        }
//        if(negative==true)
//            num=-1*num;
//        if(num<=-2147483648 || num>=2147483647)
//            return 0;
//        return (int)num;
    }

}
