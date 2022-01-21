### Garbage collector algorithm

Garbage collection works on Mark and Sweep algorithm. 
In Mark phase it detects all the unreachable objects and Sweep phase it reclaim the heap space used by the garbage objects 
and make the space available again to the program.

There are methods like System.gc() and Runtime.gc() which is used to send request of Garbage collection to 
JVM but it’s not guaranteed that garbage collection will happen. 
If there is no memory space for creating a new object in Heap Java Virtual Machine throws 
OutOfMemoryError or java.lang.OutOfMemoryError heap space

