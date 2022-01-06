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

Until here
https://www.javatpoint.com/sleep()-method

