#### Transient and Volatile

**Transient**: The transient modifier tells the Java object serialization subsystem to exclude the field when serializing an instance of the class. 
When the object is then deserialized, the field will be initialized to the default value; 
i.e. null for a reference type, and zero or false for a primitive type.

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
Volatile fields are instance or class (static) variables and are stored in the heap/RAM memory.

The Volatile keyword is used to mark the JVM and thread to read its value from primary memory and not utilize cached value present in the thread stack. 
It is used in concurrent programming in java.


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

 
#### Static
After the java 8 version, static variables are stored in the heap memory.
Declaring a static variable in Java, means that there will be only one copy, no matter how many objects of the class are created. 
The variable will be accessible even with no Objects created at all. 
However, threads may have locally cached values of it.

The static keyword belongs to the class than an instance of the class.

The static keyword is a non-access modifier in Java that is applicable for the following: 

- Blocks
- Variables
- Methods
- Classes

When a member is declared static, it can be accessed before any objects of its class are created, and without reference to any object.

Static Variables - We can create static variables at the class level only.
Use the static variable for the property that is common to all objects - Example - Aadhaar object - static variable can be countryName 
Static local variables are not allowed.
static final variables cannot be assigned value in constructor; they must be assigned a value with their declaration.

Static Methods -
Methods declared as static have several restrictions: 
They can only directly call other static methods.
They can only directly access static data.
They cannot refer to this or super in any way.

Static class
A class can be made static only if it is a nested class.
Nested static class doesn’t need a reference of Outer class. 
In this case, a static class cannot access non-static members of the Outer class. 

Binding process 
In the static method, the method use compile-time or early binding. For this reason, we can access the static method without creating an instance. 
In a non-static method, the method use runtime or dynamic binding. So that we cannot access a non-static method without creating an instance. 

Overriding 
In the static method, we cannot override a static method, because of early binding. 

A static method can only access static data members and static methods of another class or same class but cannot access non-static methods and variables. 
Also, a static method can rewrite the values of any static data member.

Memory allocation 
In the static method, memory allocation happens only once, because the static keyword fixed a particular memory for that method in ram. 
So when the method is called every time in a program, each time that particular memory is used. For that reason, less memory is allocated.

In the non-static method, here memory allocation happens when the method is invoked and the memory is allocated every time when the method is called. 
So much memory is used here. Now, lastly plotting table in order to grasp altogether.

Difference between Static and Non-Static Nested Class in Java:
The static inner class can access the static members of the outer class directly. 
But, to access the instance members of the outer class you need to instantiate the outer class.
Nested static class doesn’t need a reference of Outer class but a nonstatic nested class or Inner class requires Outer class reference.
A non-static nested class has full access to the members of the class within which it is nested. 
A static nested class does not have a reference to a nesting instance, so a static nested class cannot invoke non-static methods or 
access non-static fields of an instance of the class within which it is nested.
Another difference between static and non-static nested class is that you can not access non-static members e.g. method and field into nested static class directly. 
If you do you will get errors like “nonstatic member can not be used in the static context”. 
While the Inner class can access both static and non-static members of the Outer class.

