package references;

import java.lang.ref.SoftReference;

public class SoftReferenceDemo {
    public static void main(String[] args) {
        // Strong Reference
        MainClass g = new MainClass();
        g.message();

        // Creating Weak Reference to MainClass-type object to which 'g'
        // is also pointing.
        SoftReference<MainClass> softref = new SoftReference<MainClass>(g);
        g = null;
        g = softref.get();
        g.message();
    }

}

class MainClass
{
    public void message() {
        System.out.println("Weak References Example");
    }
}