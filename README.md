### Editions of Java

Each edition of Java has different capabilities. There are three editions of Java:

**Java Standard Editions (JSE)**: It is used to create programs for a desktop computer.
**Java Enterprise Edition (JEE)**: It is used to create large programs that run on the server and manages heavy traffic and complex transactions.
**Java Micro Edition (JME)**: It is used to develop applications for small devices such as set-top boxes, phone, and appliances.

### Features of Java

Simple: Java is a simple language because its syntax is simple, clean, and easy to understand. Complex and ambiguous concepts of C++ are either eliminated or re-implemented in Java. For example, pointer and operator overloading are not used in Java.
Object-Oriented: In Java, everything is in the form of the object. It means it has some data and behavior. A program must have at least one class and object.
Robust: Java makes an effort to check error at run time and compile time. It uses a strong memory management system called garbage collector. Exception handling and garbage collection features make it strong.
Secure: Java is a secure programming language because it has no explicit pointer and programs runs in the virtual machine. Java contains a security manager that defines the access of Java classes.
Platform-Independent: Java provides a guarantee that code writes once and run anywhere. This byte code is platform-independent and can be run on any machine.
Basics of Java
Portable: Java Byte code can be carried to any platform. No implementation-dependent features. Everything related to storage is predefined, for example, the size of primitive data types.
High Performance: Java is an interpreted language. Java enables high performance with the use of the Just-In-Time compiler.
Distributed: Java also has networking facilities. It is designed for the distributed environment of the internet because it supports TCP/IP protocol. It can run over the internet. EJB and RMI are used to create a distributed system.
Multi-threaded: Java also supports multi-threading. It means to handle more than one job a time.

OOPs (Object Oriented Programming System)
Class: A class is a template or blueprint or prototype that defines data members and methods of an object. An object is the instance of the class. We can define a class by using the class keyword.
Object: An object is a real-world entity that can be identified distinctly. For example, a desk, a circle can be considered as objects. An object has a unique behavior, identity, and state. Data fields with their current values represent the state of an object (also known as its properties or attributes).
Abstraction: An abstraction is a method of hiding irrelevant information from the user. For example, the driver only knows how to drive a car; there is no need to know how does the car run. We can make a class abstract by using the keyword abstract. In Java, we use abstract class and interface to achieve abstraction.
Encapsulation: An encapsulation is the process of binding data and functions into a single unit. A class is an example of encapsulation. In Java, Java bean is a fully encapsulated class.
Inheritance: Inheritance is the mechanism in which one class acquire all the features of another class. We can achieve inheritance by using the extends keyword. It facilitates the reusability of the code.
Polymorphism: The polymorphism is the ability to appear in many forms. In other words, single action in different ways. For example, a boy in the classroom behaves like a student, in house behaves like a son. There are two types of polymorphism: run time polymorphism and compile-time polymorphism.

### Java Platforms / Editions

There are 4 platforms or editions of Java:

1) Java SE (Java Standard Edition)

It is a Java programming platform. It includes Java programming APIs such as java.lang, java.io, java.net, java.util, java.sql, java.math etc. It includes core topics like OOPs, String, Regex, Exception, Inner classes, Multithreading, I/O Stream, Networking, AWT, Swing, Reflection, Collection, etc.

2) Java EE (Java Enterprise Edition)

It is an enterprise platform that is mainly used to develop web and enterprise applications. It is built on top of the Java SE platform. It includes topics like Servlet, JSP, Web Services, EJB, JPA, etc.

3) Java ME (Java Micro Edition)

It is a micro platform that is dedicated to mobile applications.

4) JavaFX

It is used to develop rich internet applications. It uses a lightweight user interface API.

### Java Versions
JDK Alpha and Beta (1995)
JDK 1.0 (23rd Jan 1996)
JDK 1.1 (19th Feb 1997)
J2SE 1.2 (8th Dec 1998)
J2SE 1.3 (8th May 2000)
J2SE 1.4 (6th Feb 2002)
J2SE 5.0 (30th Sep 2004)
Java SE 6 (11th Dec 2006)
Java SE 7 (28th July 2011)
Java SE 8 (18th Mar 2014)
Java SE 9 (21st Sep 2017)
Java SE 10 (20th Mar 2018)
Java SE 11 (September 2018)
Java SE 12 (March 2019)
Java SE 13 (September 2019)
Java SE 14 (Mar 2020)
Java SE 15 (September 2020)
Java SE 16 (Mar 2021)
Java SE 17 (September 2021)
Java SE 18 (to be released by March 2022)
Since Java SE 8 release, the Oracle corporation follows a pattern in which every even version is release in March month and an odd version released in September month.

###Platform Independent
Java is platform independent because it is different from other languages like C, C++, etc. which are compiled into platform specific machines while Java is a write once, run anywhere language. A platform is the hardware or software environment in which a program runs.

There are two types of platforms software-based and hardware-based. Java provides a software-based platform.
The Java platform differs from most other platforms in the sense that it is a software-based platform that runs on top of other hardware-based platforms. 
It has two components:

1.Runtime Environment
2.API(Application Programming Interface)
Java code can be executed on multiple platforms, for example, Windows, Linux, Sun Solaris, Mac/OS, etc. Java code is compiled by the compiler and converted into bytecode. 
This bytecode is a platform-independent code because it can be run on multiple platforms, i.e., Write Once and Run Anywhere (WORA).

### Secured

Java is best known for its security. With Java, we can develop virus-free systems. Java is secured because:

No explicit pointer
Java Programs run inside a virtual machine sandbox
Classloader: Classloader in Java is a part of the Java Runtime Environment (JRE) which is used to load Java classes into the Java Virtual Machine dynamically. It adds security by separating the package for the classes of the local file system from those that are imported from network sources.
Bytecode Verifier: It checks the code fragments for illegal code that can violate access rights to objects.
Security Manager: It determines what resources a class can access such as reading and writing to the local disk.

#### Valid main method signatures
public static void main(String[] args)  
public static void main(String []args)  
public static void main(String args[])  
public static void main(String... args)  
static public void main(String[] args)  
public static final void main(String[] args)  
final public static void main(String[] args)  
final strictfp public static void main(String[] args)  

#### Invalid main method signatures
public void main(String[] args)  
static void main(String[] args)  
public void static main(String[] args)  
abstract public static void main(String[] args)  

Refer
/resources/java-runtime-processing.png

Classloader: It is the subsystem of JVM that is used to load class files.
Bytecode Verifier: Checks the code fragments for illegal code that can violate access rights to objects.

Interpreter: Read bytecode stream then execute the instructions.


### JDK, JRE, and JVM
JVM

JVM (Java Virtual Machine) is an abstract machine. It is called a virtual machine because it doesn't physically exist. It is a specification that provides a runtime environment in which Java bytecode can be executed. It can also run those programs which are written in other languages and compiled to Java bytecode.

JVMs are available for many hardware and software platforms. JVM, JRE, and JDK are platform dependent because the configuration of each OS is different from each other. However, Java is platform independent. There are three notions of the JVM: specification, implementation, and instance.

The JVM performs the following main tasks:

Loads code
Verifies code
Executes code
Provides runtime environment

JRE

JRE is an acronym for Java Runtime Environment. It is also written as Java RTE. The Java Runtime Environment is a set of software tools which are used for developing Java applications. It is used to provide the runtime environment. It is the implementation of JVM. It physically exists. It contains a set of libraries + other files that JVM uses at runtime.

The implementation of JVM is also actively released by other companies besides Sun Micro Systems.

JDK

JDK is an acronym for Java Development Kit. The Java Development Kit (JDK) is a software development environment which is used to develop Java applications and applets. It physically exists. It contains JRE + development tools.

JDK is an implementation of any one of the below given Java Platforms released by Oracle Corporation:

Standard Edition Java Platform
Enterprise Edition Java Platform
Micro Edition Java Platform
The JDK contains a private Java Virtual Machine (JVM) and a few other resources such as an interpreter/loader (java), a compiler (javac), an archiver (jar), a documentation generator (Javadoc), etc. to complete the development of a Java Application.

#### JVM (Java Virtual Machine) Architecture
JVM (Java Virtual Machine) is an abstract machine. It is a specification that provides runtime environment in which java bytecode can be executed.

JVMs are available for many hardware and software platforms (i.e. JVM is platform dependent).
What is JVM

It is:

A specification where working of Java Virtual Machine is specified. But implementation provider is independent to choose the algorithm. Its implementation has been provided by Oracle and other companies.
An implementation Its implementation is known as JRE (Java Runtime Environment).
Runtime Instance Whenever you write java command on the command prompt to run the java class, an instance of JVM is created.
What it does

The JVM performs following operation:
Loads code
Verifies code
Executes code
Provides runtime environment

JVM provides definitions for the:
Memory area
Class file format
Register set
Garbage-collected heap
Fatal error reporting etc.

Refer /resources/jvm-architecture.png

#### Classloader

Classloader is a subsystem of JVM which is used to load class files. Whenever we run the java program, it is loaded first by the classloader. There are three built-in classloaders in Java.

Bootstrap ClassLoader: This is the first classloader which is the super class of Extension classloader. It loads the rt.jar file which contains all class files of Java Standard Edition like java.lang package classes, java.net package classes, java.util package classes, java.io package classes, java.sql package classes etc.
Extension ClassLoader: This is the child classloader of Bootstrap and parent classloader of System classloader. It loades the jar files located inside $JAVA_HOME/jre/lib/ext directory.
System/Application ClassLoader: This is the child classloader of Extension classloader. It loads the classfiles from classpath. By default, classpath is set to current directory. You can change the classpath using "-cp" or "-classpath" switch. It is also known as Application classloader.

These are the internal classloaders provided by Java. If you want to create your own classloader, you need to extend the ClassLoader class.

#### Class(Method) Area

Class(Method) Area stores per-class structures such as the runtime constant pool, field and method data, the code for methods.

#### Heap

It is the runtime data area in which objects are allocated.

#### Stack

Java Stack stores frames. It holds local variables and partial results, and plays a part in method invocation and return.

Each thread has a private JVM stack, created at the same time as thread.

A new frame is created each time a method is invoked. A frame is destroyed when its method invocation completes.

#### Program Counter Register

PC (program counter) register contains the address of the Java virtual machine instruction currently being executed.

#### Native Method Stack

It contains all the native methods used in the application.

#### Execution Engine
It contains:
1.A virtual processor
2.Interpreter: Read bytecode stream then execute the instructions.
3.Just-In-Time(JIT) compiler: It is used to improve the performance. JIT compiles parts of the byte code that have similar functionality at the same time, and hence reduces the amount of time needed for compilation. Here, the term "compiler" refers to a translator from the instruction set of a Java virtual machine (JVM) to the instruction set of a specific CPU.

#### Java Native Interface

Java Native Interface (JNI) is a framework which provides an interface to communicate with another application written in another language like C, C++, Assembly etc. Java uses JNI framework to send output to the Console or interact with OS libraries.

### Java Keywords
Java keywords are also known as reserved words. Keywords are particular words that act as a key to a code. These are predefined words by Java so they cannot be used as a variable or object name or class name.
List of Java Keywords

A list of Java keywords or reserved words are given below:

abstract: Java abstract keyword is used to declare an abstract class. An abstract class can provide the implementation of the interface. It can have abstract and non-abstract methods.
boolean: Java boolean keyword is used to declare a variable as a boolean type. It can hold True and False values only.
break: Java break keyword is used to break the loop or switch statement. It breaks the current flow of the program at specified conditions.
byte: Java byte keyword is used to declare a variable that can hold 8-bit data values.
case: Java case keyword is used with the switch statements to mark blocks of text.
catch: Java catch keyword is used to catch the exceptions generated by try statements. It must be used after the try block only.
char: Java char keyword is used to declare a variable that can hold unsigned 16-bit Unicode characters
class: Java class keyword is used to declare a class.
continue: Java continue keyword is used to continue the loop. It continues the current flow of the program and skips the remaining code at the specified condition.
default: Java default keyword is used to specify the default block of code in a switch statement.
do: Java do keyword is used in the control statement to declare a loop. It can iterate a part of the program several times.
double: Java double keyword is used to declare a variable that can hold 64-bit floating-point number.
else: Java else keyword is used to indicate the alternative branches in an if statement.
enum: Java enum keyword is used to define a fixed set of constants. Enum constructors are always private or default.
extends: Java extends keyword is used to indicate that a class is derived from another class or interface.
final: Java final keyword is used to indicate that a variable holds a constant value. It is used with a variable. It is used to restrict the user from updating the value of the variable.
finally: Java finally keyword indicates a block of code in a try-catch structure. This block is always executed whether an exception is handled or not.
float: Java float keyword is used to declare a variable that can hold a 32-bit floating-point number.
for: Java for keyword is used to start a for loop. It is used to execute a set of instructions/functions repeatedly when some condition becomes true. If the number of iteration is fixed, it is recommended to use for loop.
if: Java if keyword tests the condition. It executes the if block if the condition is true.
implements: Java implements keyword is used to implement an interface.
import: Java import keyword makes classes and interfaces available and accessible to the current source code.
instanceof: Java instanceof keyword is used to test whether the object is an instance of the specified class or implements an interface.
int: Java int keyword is used to declare a variable that can hold a 32-bit signed integer.
interface: Java interface keyword is used to declare an interface. It can have only abstract methods.
long: Java long keyword is used to declare a variable that can hold a 64-bit integer.
native: Java native keyword is used to specify that a method is implemented in native code using JNI (Java Native Interface).
new: Java new keyword is used to create new objects.
null: Java null keyword is used to indicate that a reference does not refer to anything. It removes the garbage value.
package: Java package keyword is used to declare a Java package that includes the classes.
private: Java private keyword is an access modifier. It is used to indicate that a method or variable may be accessed only in the class in which it is declared.
protected: Java protected keyword is an access modifier. It can be accessible within the package and outside the package but through inheritance only. It can't be applied with the class.
public: Java public keyword is an access modifier. It is used to indicate that an item is accessible anywhere. It has the widest scope among all other modifiers.
return: Java return keyword is used to return from a method when its execution is complete.
short: Java short keyword is used to declare a variable that can hold a 16-bit integer.
static: Java static keyword is used to indicate that a variable or method is a class method. The static keyword in Java is mainly used for memory management.
strictfp: Java strictfp is used to restrict the floating-point calculations to ensure portability.
super: Java super keyword is a reference variable that is used to refer to parent class objects. It can be used to invoke the immediate parent class method.
switch: The Java switch keyword contains a switch statement that executes code based on test value. The switch statement tests the equality of a variable against multiple values.
synchronized: Java synchronized keyword is used to specify the critical sections or methods in multithreaded code.
this: Java this keyword can be used to refer the current object in a method or constructor.
throw: The Java throw keyword is used to explicitly throw an exception. The throw keyword is mainly used to throw custom exceptions. It is followed by an instance.
throws: The Java throws keyword is used to declare an exception. Checked exceptions can be propagated with throws.
transient: Java transient keyword is used in serialization. If you define any data member as transient, it will not be serialized.
try: Java try keyword is used to start a block of code that will be tested for exceptions. The try block must be followed by either catch or finally block.
void: Java void keyword is used to specify that a method does not have a return value.
volatile: Java volatile keyword is used to indicate that a variable may change asynchronously.
while: Java while keyword is used to start a while loop. This loop iterates a part of the program several times. If the number of iteration is not fixed, it is recommended to use the while loop.

