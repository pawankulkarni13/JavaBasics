package references;

import java.lang.ref.*;


public class PhantomReferenceDemo {
    public static void main(String[] args) {
        //Strong Reference
        MainPhantomRefClass obj = new MainPhantomRefClass();
        obj.message();

        //Creating reference queue
        ReferenceQueue<MainPhantomRefClass> refQueue = new ReferenceQueue<MainPhantomRefClass>();

        //Creating Phantom Reference to PhantomReferenceExample-type object to which 'obj'
        //is also pointing.
        PhantomReference<MainPhantomRefClass> phantomRef = null;
        phantomRef = new PhantomReference<MainPhantomRefClass>(obj, refQueue);
        obj = null;
        obj = phantomRef.get();  //It always returns null
        obj.message(); //It shows NullPointerException

    }
}

class MainPhantomRefClass
{
    public void message() {
        System.out.println("Phantom References Example");
    }
}
