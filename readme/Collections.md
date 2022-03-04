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