### Memory Management

Memory management is the process of allocation and de-allocation of objects.
Java uses an automatic memory management system called a garbage collector.

<img src="./resources/memory.png" alt="Memory Mgmt" />

#### Method Area
Method Area is a part of the heap memory which is shared among all the threads. 
It creates when the JVM starts up. It is used to store class structure, superclass name, 
interface name, and constructors. 
The JVM stores the following kinds of information in the method area:

- A Fully qualified name of a type (ex: String)
- The type's modifiers
- Type's direct superclass name
- A structured list of the fully qualified names of super interfaces.

#### Heap Area
Heap stores the actual objects. It creates when the JVM starts up. The user can control the heap if needed. 
It can be of fixed or dynamic size. 
When you use a new keyword, the JVM creates an instance for the object in a heap. 
While the reference of that object stores in the stack. There exists only one heap for each running JVM process. 
When heap becomes full, the garbage is collected.

It is created when the JVM starts up and used by the application as long as the application runs. It stores objects and JRE classes. 
Whenever we create objects it occupies space in the heap memory while the reference of that object creates in the stack. 
It does not follow any order like the stack. It dynamically handles the memory blocks.
Memory allocated to heap lives until any one event, either program terminated or memory free does not occur. 
The elements are globally accessible in the application. 
It is a common memory space shared with all the threads. 
If the heap space is full, it throws the java.lang.OutOfMemoryError. 
Heap is divided into the following parts:

- Young generation
- Survivor space
- Old generation
- Permanent generation
- Code Cache

#### Stack Area
Stack Area generates when a thread creates. It can be of either fixed or dynamic size. 
The stack memory is allocated per thread. It is used to store data and partial results. 
It contains references to heap objects. It also holds the value itself rather than a reference to an object from the heap. 
The variables which are stored in the stack have certain visibility, called scope.

The stack memory is a physical space (in RAM) allocated to each thread at run time. 
It is created when a thread creates. Memory management in the stack follows LIFO (Last-In-First-Out) order because it is accessible globally. 
It stores the variables, references to objects, and partial results. Memory allocated to stack lives until the function returns. 
If there is no space for creating the new objects, it throws the java.lang.StackOverFlowError. 
The scope of the elements is limited to their threads. The JVM creates a separate stack for each thread.

Stack Frame: Stack frame is a data structure that contains the thread?s data. 
Thread data represents the state of the thread in the current method.

+ It is used to store partial results and data. It also performs dynamic linking, values return by methods and dispatch exceptions.
+ When a method invokes, a new frame creates. It destroys the frame when the invocation of the method completes.
+ Each frame contains own Local Variable Array (LVA), Operand Stack (OS), and Frame Data (FD).
+ The sizes of LVA, OS, and FD determined at compile time.
+ Only one frame (the frame for executing method) is active at any point in a given thread of control. 
This frame is called the current frame, and its method is known as the current method. The class of method is called the current class.
+ The frame stops the current method, if its method invokes another method or if the method completes.
+ The frame created by a thread is local to that thread and cannot be referenced by any other thread.

#### Native Method Stack
It is also known as C stack. It is a stack for native code written in a language other than Java. Java Native Interface (JNI) calls the native stack. 
The performance of the native stack depends on the OS.

#### PC Registers
Each thread has a Program Counter (PC) register associated with it. PC register stores the return address or a native pointer. 
It also contains the address of the JVM instructions currently being executed.


The major difference between Stack memory and heap memory is that the stack is used to store the order of method execution and local variables 
while the heap memory stores the objects and it uses dynamic memory allocation and deallocation. 

| Parameter      | Stack Memory | Heap |
| ----------- | ----------- | -----------|
|Application	|It stores items that have a very short life such as methods, variables, and reference variables of the objects.	|It stores objects and Java Runtime Environment (JRE) classes.|
|Ordering	|It follows the LIFO order.	|It does not follow any order because it is a dynamic memory allocation and does not have any fixed pattern for allocation and deallocation of memory blocks.|
|Flexibility	|It is not flexible because we cannot alter the allocated memory.	|It is flexible because we can alter the allocated memory.|
|Efficiency	|It has faster access, allocation, and deallocation.	|It has slower access, allocation, and deallocation.|
|Memory Size	|It is smaller in size.	|It is larger in size.|
|Java Options Used	|We can increase the stack size by using the JVM option -Xss.	|We can increase or decrease the heap memory size by using the -Xmx and -Xms JVM options.|
|Visibility or Scope	|The variables are visible only to the owner thread.	|It is visible to all threads.|
|Generation of Space	|When a thread is created, the operating system automatically allocates the stack.	|To create the heap space for the application, the language first calls the operating system at run time.|
|Distribution	|Separate stack is created for each object.	It is shared among all the threads.|
|Exception Throws	|JVM throws the java.lang.StackOverFlowError if the stack size is greater than the limit. To avoid this error, increase the stack size.	|JVM throws the java.lang.OutOfMemoryError if the JVM is unable to create a new native method.|
|Allocation/ Deallocation	|It is done automatically by the compiler.	It is done manually by the programmer.|
|Cost	|Its cost is less.	Its cost is more in comparison to stack.|
|Implementation	|Its implementation is hard.	|Its implementation is easy.|
|Order of allocation	|Memory allocation is continuous.	|Memory allocated in random order.|
|Thread-Safety	|It is thread-safe because each thread has its own stack.	|It is not thread-safe, so properly synchronization of code is required.|
