JDK: Java Development Kit is the core component of Java Environment and provides all the tools, executables and binaries required to compile, debug and execute a Java Program.

JVM: JVM is responsible for converting Byte code to the machine specific code. JVM is also platform dependent and provides core java functions like memory management, garbage collection, security etc. JVM is customizable and we can use java options to customize it, for example allocating minimum and maximum memory to JVM. JVM is called virtual because it provides an interface that does not depend on the underlying operating system and machine hardware.

JRE: Java Runtime Environment provides a platform to execute java programs. JRE consists of JVM and java binaries and other classes to execute any program successfully.

<img src="/resources/jdk.jpg" alt="Java Compiler" />

Refer: jdk.jpg

#### What is JVM?

JVM is Java Virtual Machine. It simply means that it’s a machine where java code is running. it has main four things to do — load class file, verify a class file, execute a class file, have JRE for the environment.

Now let’s understand how JVM works?
JVM contains the following things in build :
- Classloader is basically used to run java files. Whenever a class file is created first it is run by the classloader.
- Class Area is where used to store content related to class for example if we have written any method or nested class it all stores inside the class area.
- Heap is just memory storage. when you created a class that needs an object to run. heap used to have run environment store objects.
- Stack is a data structure in which helps to maintain and store method return value or system information.
- The program counter register is holding the current address of JVM which is allocated.
- Execution Engine is used to improve the performance of JVM. It contains a virtual processor, interpreter, and just-in-time compiler.

#### What is JRE?
JRE is a java runtime environment. 
It is a combination of JVM and a set of libraries and other files. 
It is just run time environment for developing java applications. 
It contains a software tool for building java projects.

#### What is JDK?
JDK is a java development kit. It contains two things like JRE and development tools like java and javac etc. 
JDK is free for us.