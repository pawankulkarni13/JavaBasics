#### Association
An Association can be defined as a relationship that has no ownership over another. 
For example, a person can be associated with multiple banks, and a bank can be related to various people, 
but no one can own the other.

#### Aggregation
The term aggregation refers to the relationship between two classes best described as a “whole/part” and “has-a” relationship. 
This kind is the most specialized version of an association relationship. 
It contains the reference to another class and is said to have ownership of that class.

Refer: aggregation.png

    Aggregation: We call aggregation those relationships whose objects have an independent 
    lifecycle, but there is ownership, and child objects cannot belong to another parent object.

Example: Since Organization has Person as employees, the relationship between them is Aggregation. 
Here is how they look like in terms of Java classes

`public class Organization {
    private List employees;
}`
 
`public class Person {
    private String name;   
}
`

    Composition: We use the term composition to refer to relationships whose objects don’t 
    have an independent lifecycle, and if the parent object is deleted, all child objects 
    will also be deleted.

Example: Since Engine is-part-of Car, the relationship between them is Composition. 
Here is how they are implemented between Java classes.

    public class Car {
         //final will make sure engine is initialized
         private final Engine engine;  
            
       public Car(){
        engine  = new Engine();
       }
    }
 
`class Engine {
     private String type;
}`

<table class="alt">
<tbody><tr><th>Aggregation</th><th>Composition</th></tr>
<tr><td>Aggregation is a weak Association.</td><td>Composition is a strong Association.</td></tr>
<tr><td>Class can exist independently without owner.</td><td>Class can not meaningfully exist without owner.</td></tr>
<tr><td>Have their own Life Time.</td><td>Life Time depends on the Owner.</td></tr>
<tr><td>A uses B.</td><td>A owns B.</td></tr>
<tr><td>Child is not owned by 1 owner.</td><td>Child can have only 1 owner.</td></tr>
<tr><td>Has-A relationship. A has B.</td><td>Part-Of relationship. B is part of A.</td></tr>
<tr><td>Denoted by a empty diamond in UML.</td><td>Denoted by a filled diamond in UML.</td></tr>
<tr><td>We do not use "final" keyword for Aggregation.</td><td>"final" keyword is used to represent Composition.</td></tr>
<tr><td>Examples:<br>- Car has a Driver.<br>- A Human uses Clothes.<br>- A Company is an aggregation of People.<br>- A Text Editor uses a File.<br>- Mobile has a SIM Card.</td><td>Examples:<br>- Engine is a part of Car.<br>- A Human owns the Heart.<br>- A Company is a composition of Accounts.<br>- A Text Editor owns a Buffer.<br>- IMEI Number is a part of a Mobile.</td></tr>
</tbody></table>

Note: "final" keyword is used in Composition to make sure child variable is initialized.

Though both Inheritance and Composition provides code reusablility, main difference between Composition and Inheritance in Java is that Composition allows reuse of code without extending it but for Inheritance you must extend the class for any reuse of code or functionality. Inheritance is an "is-a" relationship. Composition is a "has-a".

    Inhertance:
    class Fruit {
       //...
    }
    class Apple extends Fruit {
       //...
    }
    
    Composition:
    class Fruit {
       //...
    }
    class Apple {
       private Fruit fruit = new Fruit();
       //...
    }

