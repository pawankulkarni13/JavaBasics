### Marker Interface

An interface with no methods is known as marker or tagged interface. It provides some useful information to JVM/compiler so that JVM/compiler performs some special operations on it. It is used for better readability of code. Example: Serializable, Clonnable etc.


### Functional Interface
A functional interface is an interface that defines only one abstract method.

To accurately determine the interface as functional, an annotation has been added @FunctionalInterface that works on the principle of @Override. It will designate a plan and will not allow to define the second abstract method in the interface.

An interface can include as many default methods as you like while remaining functional, because default methods are not abstract.

### Default Methods
Methods which are non-abstract implementations in Interface. prefixed with keyword "default".
- If a class implements an interface, it can, but does not have to, implement the default methods already implemented in the * interface. The class inherits the default implementation.
- If a class implements several interfaces that have the same default method, then the class must implement the method with the same signature on its own. The situation is similar if one interface has a default method, and in the other the same method is abstract - no class default implementation is inherited.
- The default method cannot override the class method java.lang.Object.
- They help implement interfaces without fear of disrupting other classes.
- Avoid creating utility classes, since all the necessary methods can be represented in the interfaces themselves.
- They give classes the freedom to choose the method to be redefined.
- One of the main reasons for introducing default methods is the ability of collections in Java 8 to use lambda expressions.

### Static Interface Methods
Static interface methods are similar to default methods, except that there is no way to override them in classes that implement the interface.
- Static methods in the interface are part of the interface without the ability to use them for objects of the implementation class
- Class methods java.lang.Object cannot be overridden as static
- Static methods in the interface are used to provide helper methods, for example, checking for null, sorting collections, etc.

