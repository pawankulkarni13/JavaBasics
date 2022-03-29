#### Transient and Volatile

**Transient**: The transient modifier tells the Java object serialization subsystem to exclude the field when serializing an instance of the class. When the object is then deserialized, the field will be initialized to the default value; i.e. null for a reference type, and zero or false for a primitive type.

`public transient int limit = 5;   // will not persist`

`public int limitless;   // will persist`

**Volatile**: The volatile modifier tells the JVM that writes to the field should always be synchronously flushed to memory, 
and that reads of the field should always read from memory. 
This means that fields marked as volatile can be safely accessed and updated in a multi-thread application without 
using native or standard library-based synchronization.
Indicate to JVM that Thread should not cache value of this variable and always read it from main memory
When a variable is volatile and not static, there will be one variable for each Object. 
So, on the surface it seems there is no difference from a normal variable but totally different from static. 
However, even with Object fields, a thread may cache a variable value locally.

Refer : volatilevsstatic.png

Can be used only with variable
After Java 5, write to any volatile variable happens before any read into the volatile variable
Helps in achieving "happens-before" relationship in Java Memory model

Usage -
Double & Long are 64 bits hence platform dependence. Write may happen in two 32 bit write steps. 
Hence chance of missing one write by another. Hence use volatile In achieving Singleton

    public class MyRunnable implements Runnable {
       private volatile boolean active;
       public void run() {
          active = true;
          while (active) {    
          }
       }
       public void stop() {
          active = false;  
       }
    }
    
#### Final method and Abstract method
Final method is a method that is marked as final, i.e. it cannot be overridden anymore. Just like final class cannot be inherited anymore.

Abstract method, on the other hand, is an empty method that is ought to be overridden by the inherited class. Without overriding, you will quickly get compilation error.

#### String, StringBuffer and StringBuilder
Mutability Difference: String is immutable, if you try to alter their values, another object gets created, whereas StringBuffer and StringBuilder are mutable so they can change their values.
Thread-Safety Difference: The difference between StringBuffer and StringBuilder is that StringBuffer is thread-safe. So when the application needs to be run only in a single thread then it is 
better to use StringBuilder. StringBuilder is more efficient than StringBuffer.

#### Lambda Expressions Access to other variables
Access to external scope variables from a lambda expression is very similar to access from anonymous objects.

immutable ( effectively final - not necessarily marked as final) local variables;
class fields
static variables.
The default methods of the implemented functional interface are not allowed to be accessed inside the lambda expression.

 
#### Static Variables
Declaring a static variable in Java, means that there will be only one copy, no matter how many objects of the class are created. 
The variable will be accessible even with no Objects created at all. 
However, threads may have locally cached values of it.

