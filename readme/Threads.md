# Threads

## Multithreading
Multithreading in Java is a process of executing multiple threads simultaneously.

A thread is a lightweight sub-process, the smallest unit of processing. Multiprocessing and multithreading, both are used to achieve multitasking.

However, we use multi-threading than multiprocessing because threads use a shared memory area. They don't allocate separate memory area so saves memory, and context-switching between the threads takes less time than process.

- Threads share the same address space.
- A thread is lightweight.
- Cost of communication between the thread is low.
- A thread is a lightweight subprocess, the smallest unit of processing. It is a separate path of execution.
- Threads are independent. If there occurs exception in one thread, it doesn't affect other threads. It uses a shared memory area.

Thread class implements Runnable interface and also extends Object class.

Link to docs
https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html

### Life Cycle of Threads
4 States - New, Runnable, Blocked(Non-runnable) and Terminated. 
We also have Thread Running state which is when Thread is in execution.

- The thread is in new state if you create an instance of Thread class but before the invocation of start() method.
- The thread is in runnable state after invocation of start() method, but the thread scheduler has not selected it to be the running thread.
- The thread is in running state if the thread scheduler has selected it.
- This is the state when the thread is still alive, but is currently not eligible to run.
- A thread is in terminated or dead state when its run() method exits.

### Creating Thread
1. Extending Thread class
2. Implementing Runnable interface.

Thread class:

Thread class provide constructors and methods to create and perform operations on a thread.Thread class extends Object class and implements Runnable interface.

Runnable Interface: Functional Interface

Runnable is implemented by class Thread.
The Runnable interface should be implemented by any class whose instances are intended to be executed by a thread. 
The class must define a method of no arguments called run.

By extending Thread class
`
class MultiThread extends Thread{  

 public void run(){  
 System.out.println("Custom Thread is running...");  
 }  
 public static void main(String args[]){  
 MultiThread t1=new MultiThread();  
 t1.start();  
  }  
 }`
 
By implementing Runnable

`
class MultiThread implements Runnable{  
public void run(){  
System.out.println("Custom Thread is running...");  
}  
  
public static void main(String args[]){  
MultiThread m1=new MultiThread();  
Thread t1 =new Thread(m1);  
t1.start();  
 }  
}`

Thread scheduler in java is the part of the JVM that decides which thread should run.
There is no guarantee that which runnable thread will be chosen to run by the thread scheduler.
Only one thread at a time can run in a single process.
The thread scheduler mainly uses preemptive or time slicing scheduling to schedule the threads.
Under preemptive scheduling, the highest priority task executes until it enters the waiting or dead states or a higher priority task comes into existence. Under time slicing, a task executes for a predefined slice of time and then reenters the pool of ready tasks. The scheduler then determines which task should execute next, based on priority and other factors.

### Thread State
name, alive/dead, execution state, priority, daemon or non daemon
Execution State - NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED

Until here
https://www.javatpoint.com/sleep()-method

### Daemon Thread
Daemon threads are mostly created by the JVM to perform some background tasks like garbage collection.

- Synchronization

solves race condition
ensure thread safely update shared variable
Syncronized code is called Critical section
How Synchronization works
JVM supports Synchronization via Monitors. Every job object is associated with a monitor.

Monitor is a mutual exclusion construct that prevents multiple threads from concurrently entering critical section

Before thread enters critical section, it must get a lock from monitor

If monitor is already locked, Thread will go to BLOCKED state

When thread gets access to critical section, shared variables are copied to thread's working memory & will be written back to main memory once thread complete exection

When syncronized keyword added to static method, lock is on java.lang.Class object


### Semaphore
A semaphore controls access to a shared resource through the use of a counter. If the counter is greater than zero, then access is allowed. If it is zero, then access is denied. What the counter is counting are permits that allow access to the shared resource. Thus, to access the resource, a thread must be granted a permit from the semaphore.
    
Working of semaphore
    
In general, to use a semaphore, the thread that wants access to the shared resource tries to acquire a permit.
    
If the semaphore’s count is greater than zero, then the thread acquires a permit, which causes the semaphore’s count to be decremented.
Otherwise, the thread will be blocked until a permit can be acquired.
When the thread no longer needs an access to the shared resource, it releases the permit, which causes the semaphore’s count to be incremented.
If there is another thread waiting for a permit, then that thread will acquire a permit at that time.
Java provide Semaphore class in java.util.concurrent package that implements this mechanism

Mutex acts similarly to a binary semaphore, we can use it to implement mutual exclusion.

    Semaphores – Restrict the number of threads that can access a resource. Example, limit max 10 connections to access a file simultaneously.
    Mutex – Only one thread to access a resource at once. Example, when a client is accessing a file, no one else should have access the same file at the same time.

Mutex is the Semaphore with an access count of 1

### Race Condition
A race condition occurs when two or more threads can access shared data and 
they try to change it at the same time. 
Because the thread scheduling algorithm can swap between threads at any time, 
you don't know the order in which the threads will attempt to access the shared data. 
Therefore, the result of the change in data is dependent on the thread scheduling 
algorithm, i.e. both threads are "racing" to access/change the data.

Learning Materials
https://github.com/learning-zone/java-interview-questions/blob/master/multithreading-questions.md

yield() method pauses the currently executing thread temporarily for giving a chance to the remaining waiting threads of the same priority or higher priority to execute. 
If there is no waiting thread or all the waiting threads have a lower priority then the same thread will continue its execution. 
The yielded thread when it will get the chance for execution is decided by the thread scheduler whose behavior is vendor dependent.

join() If any executing thread t1 calls join() on t2 (i.e. t2.join()) immediately t1 will enter into waiting state until t2 completes its execution.

sleep() Based on our requirement we can make a thread to be in sleeping state for a specified period of time.

### Thread Pools
A thread pool reuses previously created threads to execute current tasks and offers a solution to the problem of thread cycle overhead and resource thrashing. 


### CountDownLatch
CountDownLatch is used to make sure that a task waits for other threads before it starts. To understand its application, 
let us consider a server where the main task can only start when all the required services have started.

Working of CountDownLatch:
When we create an object of CountDownLatch, we specify the number of threads it should wait for, 
all such thread are required to do count down by calling CountDownLatch.countDown() once they are completed or ready to the job. 
As soon as count reaches zero, the waiting task starts running.

### Callable vs Runnable
There are two ways of creating threads – one by extending the Thread class and other by creating a thread with a Runnable. 
However, one feature lacking in  Runnable is that we cannot make a thread return result when it terminates, i.e. when run() completes. 
For supporting this feature, the Callable interface is present in Java.

A thread can’t be created with a Callable, it can only be created with a Runnable.
Another difference is that the call() method can throw an exception whereas run() cannot.

### ExecutorService
- ThreadPoolExecutor — for executing tasks using a pool of threads. Once a thread is finished executing the task, it goes back into the pool. 
If all threads in the pool are busy, then the task has to wait for its turn.
- ScheduledThreadPoolExecutor allows to schedule task execution instead of running it immediately when a thread is available. 
It can also schedule tasks with fixed rate or fixed delay.
- ForkJoinPool is a special ExecutorService for dealing with recursive algorithms tasks. If you use a regular ThreadPoolExecutor for a recursive algorithm, 
you will quickly find all your threads are busy waiting for the lower levels of recursion to finish. 
The ForkJoinPool implements the so-called work-stealing algorithm that allows it to use available threads more efficiently.


- If Two Threads Call a Synchronized Method on Different Object Instances Simultaneously, Could One of These Threads Block? What If the Method Is Static?
If the method is an instance method, then the instance acts as a monitor for the method. 
Two threads calling the method on different instances acquire different monitors, so none of them gets blocked.

If the method is static, then the monitor is the Class object. For both threads, the monitor is the same, 
so one of them will probably block and wait for another to exit the synchronized method.

- Deadlock is a condition within a group of threads that cannot make progress because every thread in the group has to acquire some resource 
that is already acquired by another thread in the group. The most simple case is when two threads need to lock both of two resources to progress, 
the first resource is already locked by one thread, and the second by another. These threads will never acquire a lock to both resources and 
thus will never progress.

- Livelock is a case of multiple threads reacting to conditions, or events, generated by themselves. An event occurs in one thread and has to be 
processed by another thread. During this processing, a new event occurs which has to be processed in the first thread, and so on. 
Such threads are alive and not blocked, but still, do not make any progress because they overwhelm each other with useless work.

- Starvation is a case of a thread unable to acquire resource because other thread (or threads) occupy it for too long or have higher priority. 
A thread cannot make progress and thus is unable to fulfill useful work.