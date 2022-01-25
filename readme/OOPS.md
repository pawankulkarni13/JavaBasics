## OOPS
- Inheritance
- Encapsulation
- Polymorphism
- Data Abstraction

### Encapsulation
Data Encapsulation is an Object-Oriented Programming concept of hiding the data attributes and their behaviors in a single unit.

It is used for the security of the private properties of an object and hence serves the purpose of data hiding.

Encapsulation as the method of putting everything that is required to do the job, inside a capsule and presenting that capsule to the user. 
Encapsulation is the process of binding data members and methods of a program together to do a specific job, without revealing unnecessary details.

Encapsulation can also be defined in two different ways:

1) Data hiding: Encapsulation is the process of hiding unwanted information, such as restricting access to any member of an object.

2) Data binding: Encapsulation is the process of binding the data members and the methods together as a whole, as a class.

### Polymorphism
Polymorphism is composed of two words - “poly” which means “many”, and “morph” which means “shapes”. Therefore Polymorphism refers to something that has many shapes.

Polymorphism refers to the process by which some code, data, method, or object behaves differently under different circumstances or contexts. Compile-time polymorphism and Run time polymorphism are the two types of polymorphisms in OOPs languages. 

### Inheritance

The term “inheritance” means “receiving some quality or behavior from a parent to an offspring.” In object-oriented programming, inheritance is the mechanism by which an object or class (referred to as a child) is created using the definition of another object or class (referred to as a parent). Inheritance not only helps to keep the implementation simpler but also helps to facilitate code reuse.

Why multiple inheritance not supported in Java?

When a class inherit from two or more classes, there is a chance two methods with same signature exist in both the super classes. So compiler will face ambiguity situation on choosing between the two method implementation. So in Java, multiple inheritance is not supported by default.

    class A {
    
    }
    
    class B {
    
    }
    
    class C extends A,B {
    
    // Error not possible
    
    }

How multiple inheritance indirectly achieved in Java?
In Java, multiple inheritance is indirectly implemented using Interface. So a class can implement more than one interface at time.

If two interfaces have methods with same signature, Java will take the implementation given in the class for both the interface methods.

### Abstraction
Abstraction is the method of hiding unnecessary details from the necessary ones. It is one of the main features of OOPs. 
For example, consider a car. You only need to know how to run a car, and not how the wires are connected inside it. This is obtained using Abstraction.
Data abstraction is accomplished with the help of abstract methods or abstract classes.


