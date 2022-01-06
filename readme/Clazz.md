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
ClassNotFoundException is an exception that occurs when you try to load a class at run time using Class.forName() or loadClass() methods and mentioned classes are not found in the classpath.
NoClassDefFoundError is an error that occurs when a particular class is present at compile time, but was missing at run time.

