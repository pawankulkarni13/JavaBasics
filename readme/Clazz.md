### Inner class and Sub class
Nested Inner class can access any private instance variable of outer class. Like any other instance variable, we can have access modifier private, protected, public and default modifier.

`class Outer { 
   class Inner { 
      public void show() { 
           System.out.println("In a nested class method"); 
      } 
   } 
}`

`class Main { 
   public static void main(String[] args) { 
       Outer.Inner in = new Outer().new Inner(); 
       in.show(); 
   } 
}`

A subclass is class which inherits a method or methods from a superclass.

`class Car {
    //...
}`
 
`class HybridCar extends Car {
    //...
}`


Abstraction solves the problem at design level while Encapsulation solves it implementation level. 
In Java, Abstraction is supported using `interface` and `abstract class` while Encapsulation is supported using access modifiers e.g. public, private and protected.
Abstraction is about hiding unwanted details while giving out most essential details, while Encapsulation means hiding the code and data into a single unit e.g. class or method to protect inner working of an object from outside world. 

<table class="alt">
<tbody><tr><th>Abstraction</th><th>Encapsulation</th></tr>
<tr><td>Abstraction is a process of hiding the implementation details and showing only functionality to the user.</td>
<td> Encapsulation is a process of wrapping code and data together into a single unit</td></tr>
<tr><td>Abstraction lets you focus on what the object does instead of how it does it.</td>
<td>Encapsulation provides you the control over the data and keeping it safe from outside misuse.</td></tr>
<tr><td>Abstraction solves the problem in the Design Level.</td>
<td>Encapsulation solves the problem in the Implementation Level.</td></tr>
<tr><td>Abstraction is implemented by using Interfaces and Abstract Classes.</td>
<td>Encapsulation is implemented by using Access Modifiers (private, default, protected, public)</td></tr>
<tr><td>Abstraction means hiding implementation complexities by using interfaces and abstract class.</td>
<td>Encapsulation means hiding data by using setters and getters.</td></tr>
</tbody></table>

#### Static Methods Restriction
If a method is declared as static, it is a member of a class rather than belonging to the object of the class. It can be called without creating an object of the class. A static method also has the power to access static data members of the class.

There are a few restrictions imposed on a static method
- The static method cannot use non-static data member or invoke non-static method directly.
- The this and super cannot be used in static context.
- The static method can access only static type data (static type instance variable).
- There is no need to create an object of the class to invoke the static method.
- A static method cannot be overridden in a subclass.


    class Parent {
       static void display() {
          System.out.println("Super class");    
       }
    }
    public class Example extends Parent {
       void display()  // trying to override display() {
          System.out.println("Sub class");  
       }
       public static void main(String[] args) {
          Parent obj = new Example();
          obj.display();
       }
    }
This generates a compile time error. The output is as follows −

    Example.java:10: error: display() in Example cannot override display() in Parent
    void display()  // trying to override display()
         ^
    overridden method is static
    
    1 error

Can we Overload or Override static methods in java? 
- Overriding : Overriding is related to run-time polymorphism. A subclass (or derived class) provides a specific implementation of a method in superclass (or base class) at runtime.
- Overloading: Overloading is related to compile time (or static) polymorphism. This feature allows different methods to have same name, but different signatures, especially number of input parameters and type of input paramaters.
- Can we overload static methods?   The answer is ‘Yes’. We can have two ore more static methods with same name, but differences in input parameters
- Can we Override static methods in java?  We can declare static methods with same signature in subclass, but it is not considered overriding as there won’t be any run-time polymorphism. 
Hence the answer is ‘No’. Static methods cannot be overridden because method overriding only occurs in the context of dynamic (i.e. runtime) lookup of methods. 
Static methods (by their name) are looked up statically (i.e. at compile-time).    

#### Ways to Load class 
- Creating a reference using new

`Object someInstance = new SomeClazz();`

- Using Class.forName(String):

`Class.forName("SomeClazz");`

- Using SystemClassLoader():
   
`ClassLoader.getSystemClassLoader().loadClass("SomeClass");`

- Using Overloaded Class.forName():

`Class.forName(String name, boolean initialize, ClassLoader loader);`


#### ClassNotFoundException vs NoClassDefFoundError 
ClassNotFoundException is an exception that occurs when you try to load a class at run time using Class.forName() or loadClass() 
methods and mentioned classes are not found in the classpath.
NoClassDefFoundError is an error that occurs when a particular class is present at compile time, but was missing at run time.

#### Static class
In Java, the static keyword typically flags a method or field as existing not once per instance of a class, but once ever. 
A class exists once anyway so in effect, all classes are "static" in this way and all objects are instances of classes.

static does have a meaning for inner classes, which is entirely different: Usually an inner class instance can access the members of an outer class instance 
that it's tied to, but if the inner class is static, it does not have such a reference and can be instantiated without an instance of the outer class. 
Maybe you saw that someplace, then tried to use it on a top-level class, where it isn't meaningful.
Java has no way of making a top-level class static but you can simulate a static class like this:

Declare your class final - Prevents extension of the class since extending a static class makes no sense
Make the constructor private - Prevents instantiation by client code as it makes no sense to instantiate a static class
Make all the members and functions of the class static - Since the class cannot be instantiated no instance methods can be called or instance fields accessed
Note that the compiler will not prevent you from declaring an instance (non-static) member. The issue will only show up if you attempt to call the instance member.

#### Reflection 
is an API which is used to examine or modify the behavior of methods, classes, interfaces at runtime.
     
The required classes for reflection are provided under java.lang.reflect package.
Reflection gives us information about the class to which an object belongs and also the methods of that class which can be executed by using the object.
Through reflection we can invoke methods at runtime irrespective of the access specifier used with them.

Advantages of Using Reflection:

Extensibility Features: An application may make use of external, user-defined classes by creating instances of extensibility objects 
using their fully-qualified names.
Debugging and testing tools: Debuggers use the property of reflection to examine private members on classes.
 

Drawbacks:

Performance Overhead: Reflective operations have slower performance than their non-reflective counterparts, and should be avoided 
in sections of code which are called frequently in performance-sensitive applications.
Exposure of Internals: Reflective code breaks abstractions and therefore may change behavior with upgrades of the platform.


#### new operator vs newInstance() method
In general, new operator is used to create objects, but if we want to decide type of object to be created at runtime, there is no way we can use new operator. 
In this case, we have to use newInstance() method.

#### instanceof operator vs isInstance() 
The instanceof operator and isInstance() method both are used for checking the class of the object. 
But the main difference comes when we want to check the class of objects dynamically then isInstance() method will work. 
There is no way we can do this by instanceof operator.

The isInstance method is equivalent to instanceof operator. 
The method is used in case of objects are created at runtime using reflection. 
General practice says if the type is to be checked at runtime then use the isInstance method otherwise instanceof operator can be used.

The instanceof operator and isInstance() method both return a boolean value. 
isInstance() method is a method of class Class in java while instanceof is an operator. 

