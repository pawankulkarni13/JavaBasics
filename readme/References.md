### References in Java

In Java there are four types of references differentiated on the way by which they are garbage collected.

1. Strong References
2. Weak References
3. Soft References
4. Phantom References

#### Strong References: 
This is the default type/class of Reference Object. Any object which has an active strong reference are not eligible for garbage collection. The object is garbage collected only when the variable which was strongly referenced points to null.

`MyClass obj = new MyClass();`

#### Weak References: 
Weak Reference Objects are not the default type/class of Reference Object and they should be explicitly specified while using them.

    //Java Code to illustrate Weak reference 
    import java.lang.ref.WeakReference; 
    class MainClass 
    { 
        public void message() { 
            System.out.println("Weak References Example"); 
        } 
    } 
  
    public class Example 
    { 
        public static void main(String[] args) { 
            // Strong Reference 
            MainClass g = new MainClass();    
            g.message();       
        // Creating Weak Reference to MainClass-type object to which 'g'  
            // is also pointing. 
            WeakReference<MainClass> weakref = new WeakReference<MainClass>(g); 
            g = null;  
            g = weakref.get();  
            g.message(); 
        } 
    }
    
#### Soft References: 
In Soft reference, even if the object is free for garbage collection then also its not garbage collected, until JVM is in need of memory badly.The objects gets cleared from the memory when JVM runs out of memory.To create such references java.lang.ref.SoftReference class is used.
     
    //Java Code to illustrate Weak reference 
    import java.lang.ref.SoftReference; 
    class MainClass 
    { 
        public void message() { 
            System.out.println("Weak References Example"); 
        } 
    } 
      
    public class Example 
    { 
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
    
#### Phantom References: 
The objects which are being referenced by phantom references are eligible for garbage collection. But, before removing them from the memory, JVM puts them in a queue called ‘reference queue’ . They are put in a reference queue after calling finalize() method on them.To create such references java.lang.ref.PhantomReference class is used.

    //Java Code to illustrate Weak reference 
    import java.lang.ref.*; 
    class MainClass 
    { 
        public void message() { 
            System.out.println("Phantom References Example"); 
        } 
    } 
      
    public class Example 
    { 
        public static void main(String[] args) { 
            // Strong Reference 
            MainClass g = new MainClass();    
            g.message(); 
            // Creating Phantom Reference to MainClass-type object to which 'g'  
            // is also pointing. 
            PhantomReference<MainClass> phantomRef = null; 
            phantomRef = new PhantomReference<MainClass>(g,refQueue); 
            g = null; 
            g = phantomRef.get();  
            g.message(); 
        } 
    }
    
