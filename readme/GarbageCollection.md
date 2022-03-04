### Garbage collector algorithm

Garbage collection works on Mark and Sweep algorithm. 
In Mark phase it detects all the unreachable objects and Sweep phase it reclaim the heap space used by the garbage objects 
and make the space available again to the program.

There are methods like System.gc() and Runtime.gc() which is used to send request of Garbage collection to 
JVM but it’s not guaranteed that garbage collection will happen. 
If there is no memory space for creating a new object in Heap Java Virtual Machine throws 
OutOfMemoryError or java.lang.OutOfMemoryError heap space

Types of Garbage Collection
There are five types of garbage collection are as follows:

1. Serial GC: It uses the mark and sweeps approach for young and old generations, which is minor and major GC.
2. Parallel GC: It is similar to serial GC except that, it spawns N (the number of CPU cores in the system) threads for young generation garbage collection.
3. Parallel Old GC: It is similar to parallel GC, except that it uses multiple threads for both generations.
4. Concurrent Mark Sweep (CMS) Collector: It does the garbage collection for the old generation. 
You can limit the number of threads in CMS collector using XX:ParalleCMSThreads=JVM option. It is also known as Concurrent Low Pause Collector.
5. G1 Garbage Collector: It introduced in Java 7. Its objective is to replace the CMS collector. It is a parallel, concurrent, and CMS collector. 
There is no young and old generation space. It divides the heap into several equal sized heaps. It first collects the regions with lesser live data.

