package references;

import java.lang.ref.WeakReference;

/**
 * Refer References.md
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        // Strong Reference
        MainSoftRefClass g = new MainSoftRefClass();
        g.message();

        // Creating Weak Reference to MainClass-type object to which 'g'
        // is also pointing.
        WeakReference<MainSoftRefClass> weakref = new WeakReference<MainSoftRefClass>(g);
        g = null;
        g = weakref.get();
        g.message();
    }
}

class MainSoftRefClass
{
    public void message() {
        System.out.println("Weak References Example");
    }
}
