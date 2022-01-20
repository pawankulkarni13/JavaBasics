package programs;

public class JavaTricksDemo {

    public static void main(String[] args) {

        //1
        // \u000d System.out.println("Yeah this prints in logs!!");


        //2
        int x = 123_34;
        System.out.println(x);

        //3
        //An integer can be null, so this is fine
        Integer i = null;
        //Unboxing null to integer throws NullpointerException
//        int a = i;


        //4
        JavaTricksDemo obj = null;
        obj.staticMethod();
//        obj.nonStaticMethod();    NPE

        //5
        //return true;
        System.out.println(null==null);

        //return false;
        System.out.println(null!=null);
    }
    private static void staticMethod()
    {
        //Can be called by null reference
        System.out.println("static method, can be called by null reference");

    }

    private void nonStaticMethod()
    {
        //Can not be called by null reference
        System.out.print(" Non-static method- ");
        System.out.println("cannot be called by null reference");

    }
}
