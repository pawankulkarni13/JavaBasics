# SOLID
SOLID is an acronym for the first five object-oriented design (OOD) principles by Robert C. Martin.

These principles establish practices that lend to developing software with considerations for maintaining and extending as the project grows. Adopting these practices can also contribute to avoiding code smells, refactoring code, and Agile or Adaptive software development.

SOLID stands for:

- S - Single-responsiblity Principle.
- O - Open-closed Principle
- L - Liskov Substitution Principle
- I - Interface Segregation Principle
- D - Dependency Inversion Principle.

## Single-Responsibility Principle
Single-responsibility Principle (SRP) states:

A class should have one and only one reason to change, meaning that a class should have only one job.

Example : 
Consider an application that takes a collection of shapes - circles and squares, and calculates the sum of the area of all the shapes in the collection.
Let's assume we have ShapeAreaCalculator as the class doing the calculation based on the type of shape as request.
Other than calculation we also have the output/print method in the class.
The problem with the output method is that the ShapeAreaCalculator handles the logic to output the data.
Further more if we have a requirement to output it to JSON/XML. We end up having the logic in the Calculator class.

All of the logic would be handled by the ShapeAreaCalculator class. This would violate the single-responsibility principle. 
The ShapeAreaCalculator class should only be concerned with the sum of the areas of provided shapes. 
It should not care whether the user wants JSON or HTML.
In order to resolve this, we can create AreaOutputter class and use that new class to handle the logic you need to output the data to the user.

## Open-Closed Principle

Open-closed Principle (OCP) states:

Objects or entities should be open for extension but closed for modification.

This means that a class should be extendable without modifying the class itself.

Example : 
Consider an application that takes a collection of shapes - circles and squares, and calculates the sum of the area of all the shapes in the collection.
Let's assume we have ShapeAreaCalculator as the class doing the Area calculation based on the type of shape as request.
Consider a scenario where the user would like the Sum of Areas of additional shapes like triangles, pentagons, hexagons, etc. 
You would have to constantly edit this file and add more if/else blocks. That would violate the open-closed principle.
A way you can make this sum method better is to remove the logic to calculate the area of each shape out of the ShapeAreaCalculator class method and attach it to each shape’s class.
So you would have area() method implemented in each Shape class and ShapeAreaCalculator can easily use this reference.

However, another problem arises. How do you know that the object passed into the ShapeAreaCalculator is actually a shape or if the shape has a method named area?
Coding to an interface is an integral part of SOLID.
Create a ShapeInterface that supports area method. Modify your Shape classes to implement the Interface.
This now satisfies OCP.

## Liskov Substitution Principle
Liskov Substitution Principle states:
   
Let q(x) be a property provable about objects of x of type T. Then q(y) should be provable for objects y of type S where S is a subtype of T.

This means that every subclass or derived class should be substitutable for their base or parent class.

## Interface Segregation Principle
Interface segregation principle states:
   
A client should never be forced to implement an interface that it doesnot use, or clients shouldn’t be forced to depend on methods they do not use.

Example :
Still building from the previous ShapeInterface example, you will need to support the new three-dimensional shapes of Cuboid and Spheroid, and these shapes will need to also calculate volume.
Lets consider we add volume() method to the interface.
Now, any shape you create must implement the volume method, but you know that squares are flat shapes and that they do not have volumes, so this interface would force the Square class to implement a method that it has no use of.
This would violate the interface segregation principle. 
Instead, you could create another interface called ThreeDimensionalShapeInterface that has the volume contract and three-dimensional shapes can implement this interface.

This is a much better approach, but a pitfall to watch out for is when type-hinting these interfaces. 
Instead of using a ShapeInterface or a ThreeDimensionalShapeInterface, you can create another interface, maybe ManageShapeInterface, and implement it on both the flat and three-dimensional shapes.
This way, you can have a single API for managing the shapes.

## Dependency Inversion Principle
Dependency inversion principle states:

Entities must depend on abstractions, not on concretions. It states that the high-level module must not depend on the low-level module, but they should depend on abstractions.
This principle allows for de-coupling.

Example:
In a CRUD API operation. The logic/service classes should not be tied to Database specific connections/calls. 
Instead, create a DBInterface which does all the low-level handling with database, i.e connection establishment, session management etc.
In this way the service module which seems a high-level module is dependent only on abstraction.


## Conclusion
Projects that adhere to SOLID principles can be shared with collaborators, extended, modified, tested, and refactored with fewer complications.
