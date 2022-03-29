### Comparable vs Comparator
Comparable: A comparable object is capable of comparing itself with another object. 
The class itself must implements the java.lang.Comparable interface in order to be able to compare its instances.

Comparator: A comparator object is capable of comparing two different objects. The class is not comparing its instances, but some other class’s instances. 
This comparator class must implement the java.util.Comparator interface.

### Fail fast Iterator vs fail-safe Iterator
fail-fast Iterator

Iterators in java are used to iterate over the Collection objects.
Fail-Fast iterators immediately throw ConcurrentModificationException if there is structural modification of the collection. 
Iterator on ArrayList, HashMap classes are some examples of fail-fast Iterator.

Structural modification means adding, removing or updating any element from collection while a thread is iterating over that collection. 

fail-safe Iterator

Fail-Safe iterators don’t throw any exceptions if a collection is structurally modified while iterating over it. 
This is because, they operate on the clone of the collection, not on the original collection and that’s why they are called fail-safe iterators. 
Iterator on CopyOnWriteArrayList, ConcurrentHashMap classes are examples of fail-safe Iterator.

### ArrayList vs LinkedList
LinkedList is fast for adding and deleting elements, but slow to access a specific element. 
ArrayList is fast for accessing a specific element but can be slow to add to either end, and especially slow to delete in the middle.

==================================================================================================================================

### BlockingQueue
The term blocking queue comes from the fact that the Java BlockingQueue is capable of blocking the threads that
try to insert or take elements from the queue. 
For instance, if a thread tries to take an element and there are none left in the queue, 
the thread can be blocked until there is an element to take. 
Whether or not the calling thread is blocked depends on what methods you call on the BlockingQueue. 


Implementations of the BlockingQueue interface:
 
 ArrayBlockingQueue
 DelayQueue
 LinkedBlockingQueue
 LinkedBlockingDeque
 LinkedTransferQueue
 PriorityBlockingQueue
 SynchronousQueue
 
A BlockingQueue is typically used to have one thread produce objects, which another thread consumes. 

The 4 different sets of behaviour means this:
- Throws Exception: add(o), remove(o),	element()	
If the attempted operation is not possible immediately, an exception is thrown.
- Special Value: offer(o),	poll(), peek()	
If the attempted operation is not possible immediately, a special value is returned (often true / false).
- Blocks: put(o), take()	
If the attempted operation is not possible immedidately, the method call blocks until it is.
- Times Out: offer(o, timeout, timeunit), poll(timeout, timeunit)
If the attempted operation is not possible immedidately, the method call blocks until it is, but waits no longer than the given timeout. 
Returns a special value telling whether the operation succeeded or not (typically true / false).

It is not possible to insert null into a BlockingQueue. If you try to insert null, the BlockingQueue will throw a NullPointerException.


==================================================================================================================================

### ArrayBlockingQueue 
The ArrayBlockingQueue class implements the BlockingQueue interface.
ArrayBlockingQueue is a bounded, blocking queue that stores the elements internally in an array. 
That it is bounded means that it cannot store unlimited amounts of elements. 
There is an upper bound on the number of elements it can store at the same time. You set the upper bound at instantiation time, 
and after that it cannot be changed.

The ArrayBlockingQueue stores the elements internally in FIFO (First In, First Out) order. 
The head of the queue is the element which has been in queue the longest time, and the tail of the queue is the element 
which has been in the queue the shortest time.

==================================================================================================================================

### DelayQueue
DelayQueue class implements the BlockingQueue interface.
The DelayQueue blocks the elements internally until a certain delay has expired. 
The elements must implement the interface java.util.concurrent.Delayed. Here is how the interface looks:
    
    public interface Delayed extends Comparable<Delayed< {
    
     public long getDelay(TimeUnit timeUnit);
    
    }



==================================================================================================================================

### LinkedBlockingQueue
The LinkedBlockingQueue class implements the BlockingQueue interface.
The LinkedBlockingQueue keeps the elements internally in a linked structure (linked nodes). 
This linked structure can optionally have an upper bound if desired. 
If no upper bound is specified, Integer.MAX_VALUE is used as the upper bound.

The LinkedBlockingQueue stores the elements internally in FIFO (First In, First Out) order. 
The head of the queue is the element which has been in queue the longest time, and the tail of the queue is the element 
which has been in the queue the shortest time.


==================================================================================================================================

### PriorityBlockingQueue
The PriorityBlockingQueue class implements the BlockingQueue interface.
The PriorityBlockingQueue is an unbounded concurrent queue. It uses the same ordering rules as the java.util.PriorityQueue class. 
You cannot insert null into this queue.

All elements inserted into the PriorityBlockingQueue must implement the java.lang.Comparable interface. 
The elements thus order themselves according to whatever priority you decide in your Comparable implementation.

Notice that the PriorityBlockingQueue does not enforce any specific behaviour for elements that have equal priority (compare() == 0).
An Iterator from a PriorityBlockingQueue, the Iterator does not guarantee to iterate the elements in priority order.



==================================================================================================================================

### SynchronousQueue
The SynchronousQueue class implements the BlockingQueue interface. 
The SynchronousQueue is a queue that can be used to exchange a single element with another thread. 
A thread inserting an element into the queue is blocked until another thread takes that element from the queue. 
Likewise, if a thread tries to take an element and no element is currently present, that thread is blocked until a 
thread insert an element into the queue.



==================================================================================================================================

### BlockingDeque
The BlockingDeque class is a Deque which blocks threads trying to insert or remove elements from the deque, 
in case it is either not possible to insert or remove elements from the deque.
A deque is short for "Double Ended Queue". Thus, a deque is a queue which you can insert and take elements from, from both ends.

A BlockingDeque could be used if threads are both producing and consuming elements of the same queue. 
It could also just be used if the producing thread needs to insert at both ends of the queue, 
and the consuming thread needs to remove from both ends of the queue.

A BlockingDeque - threads can put and take from both ends of the deque.
A thread will produce elements and insert them into either end of the queue. 
If the deque is currently full, the inserting thread will be blocked until a removing thread takes an element out of the deque. 
If the deque is currently empty, a removing thread will be blocked until an inserting thread inserts an element into the deque.

A BlockingDeque has 4 different sets of methods for inserting, removing and examining the elements in the deque. 
Each set of methods behaves differently in case the requested operation cannot be carried out immediately.

The 4 different sets of behaviour means this:

- Throws Exception: addFirst(o), removeFirst(o), getFirst(o), addLast(o), removeLast(o), getLast(o)
If the attempted operation is not possible immediately, an exception is thrown.
- Special Value: offerFirst(o), pollFirst(o), peekFirst(o), offerLast(o), pollLast(o), peekLast(o)
If the attempted operation is not possible immediately, a special value is returned (often true / false).
- Blocks: putFirst(o), takeFirst(o), putLast(o), takeLast(o)
If the attempted operation is not possible immedidately, the method call blocks until it is.
- Times Out: offerFirst(o, timeout, timeunit), pollFirst(timeout, timeunit), offerLast(o, timeout, timeunit), pollLast(timeout, timeunit)
If the attempted operation is not possible immedidately, the method call blocks until it is, but waits no longer than the given timeout. 
Returns a special value telling whether the operation succeeded or not (typically true / false).

The BlockingDeque interface extends the BlockingQueue interface. 
That means that you can use a BlockingDeque as a BlockingQueue. If you do so, the various inserting methods will add the 
elements to the end of the deque, and the removing methods will remove the elements from the beginning of the deque. 

Implementations :
 LinkedBlockingDeque

==================================================================================================================================

### LinkedBlockingDeque
The LinkedBlockingDeque class implements the BlockingDeque interface.
The word Deque comes from the term "Double Ended Queue". 
A Deque is thus a queue where you can insert and remove elements from both ends of the queue.

The LinkedBlockingDeque is a Deque which will block if a thread attempts to take elements out of it while it is empty, 
regardless of what end the thread is attempting to take elements from.


==================================================================================================================================

### ConcurrentMap
The java.util.concurrent.ConcurrentMap interface represents a Map which is capable of handling concurrent access (puts and gets) to it.

The ConcurrentMap has a few extra atomic methods in addition to the methods it inherits from its superinterface, java.util.Map.

ConcurrentMap Implementations:
 ConcurrentHashMap 


==================================================================================================================================

### ConcurrentHashMap
The ConcurrentHashMap is very similar to the java.util.HashTable class, except that ConcurrentHashMap offers better concurrency than HashTable does. 
ConcurrentHashMap does not lock the Map while you are reading from it. 
Additionally, ConcurrentHashMap does not lock the entire Map when writing to it. 
It only locks the part of the Map that is being written to, internally.

Another difference is that ConcurrentHashMap does not throw ConcurrentModificationException if the ConcurrentHashMap is changed while being iterated. 
The Iterator is not designed to be used by more than one thread though.

https://www.journaldev.com/122/concurrenthashmap-in-java

==================================================================================================================================

### ConcurrentNavigableMap
The java.util.concurrent.ConcurrentNavigableMap interface extending a java.util.NavigableMap with support for concurrent access, 
and which has concurrent access enabled for its submaps. 
The "submaps" are the maps returned by various methods like headMap(), subMap() and tailMap().

headMap()
The headMap(T toKey) method returns a view of the map containing the keys which are strictly less than the given key.
If you make changes to the original map, these changes are reflected in the head map.

tailMap()
The tailMap(T fromKey) method returns a view of the map containing the keys which are greater than or equal to the given fromKey.
If you make changes to the original map, these changes are reflected in the tail map.

subMap()
The subMap() method returns a view of the original map which contains all keys from (including), to (excluding) two keys given as parameters to the method.

==================================================================================================================================



==================================================================================================================================
