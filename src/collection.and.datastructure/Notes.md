![](1_qgcrVwo8qzF4muOQ-kKB8A.jpg)
- List is interface
```java
interface List<E>
```
E :- type of element

- An ordered collection (also known as a sequence). 
- The user of this interface has precise control over where in the list each element is inserted. The user can access elements by their integer index (position in the list), and search for elements in the list.
- Allows duplicate elements and null values (depending on the implementation).


#### ArrayList
- Implements List<E> using a dynamic, resizable array.
- so same advantage and disadvantages as arrays
- since 1.2
- Default initial capacity is 10; grows dynamically (e.g., by ~50% when full)
- Not thread-safe (use Collections.synchronizedList for synchronization).
- Fast random access (O(1)), but slow for insertions/deletions in the middle (O(n)).
- abstract data type
  - An abstract data type defines operations without specifying the underlying implementation
  - concrete data structure is usually a concrete class
  - abstract data type is usually an interface
- Extends AbstractList and implements List<E>, RandomAccess, Cloneable, and Serializable.
- **When to use?** When you need fast random access and infrequent insertions/removals.


### vector
- thread safe arraylist
- comes before arraylist
- since 1.0
- Higher performance overhead compared to ArrayList due to synchronization.
- uses array
- **When to use?** Only when working in a multi-threaded environment where synchronization is required.


### linked List
- class
- Nodes
- first is head
- extend abstractsequentiallist
- Extends AbstractSequentialList and implements List<E>, Deque<E>, Cloneable, and Serializable
- Implemented as a doubly linked list.
- implementation is not synchronized
- Efficient for insertions/deletions (O(1) if position known), but slow for random access (O(n)).
- **When to use?** When frequent insertions and deletions occur.


### stack class
- Extends Vector, implementing a LIFO (Last-In-First-Out) stack using an array.
- better to use Deque
- push, pop, peek
- Deque (e.g., ArrayDeque) is preferred for stack operations due to better performance and flexibility.
- **When to use?** When following LIFO order (e.g., expression evaluation, backtracking problems, undo operations).


### queue
- interface
- FIFO
- add, remove, peek
- 
| Operation | Throws Exception | Returns Special Value |  
|-----------|----------------|---------------------|  
| **Insert**  | `add(e)`      | `offer(e)`         |  
| **Remove**  | `remove()`    | `poll()`           |  
| **Examine** | `element()`   | `peek()`           |  


### deque
- interface
- support insertion and removal at both ends

| Operation  | First Element (Head) |  | Last Element (Tail) |  |  
|------------|---------------------|------------------|---------------------|------------------|  
|            | **Throws Exception** | **Special Value** | **Throws Exception** | **Special Value** |  
| **Insert** | `addFirst(e)`        | `offerFirst(e)`  | `addLast(e)`        | `offerLast(e)`  |  
| **Remove** | `removeFirst()`      | `pollFirst()`    | `removeLast()`      | `pollLast()`    |  
| **Examine** | `getFirst()`        | `peekFirst()`    | `getLast()`        | `peekLast()`    |  




### CopyOnWriteArrayList
- Thread-safe variant of arrayList
- Create a new copy of the array on each write operaion 


### priorityQueue
- class extends AbstractQueue<> implements Serializable
- ordered according to their natural ordering , or by comparator
-  A priority queue does not permit null elements
- Note that this implementation is not synchronized.
-  implementation provides O(log(n)) time for the enqueuing and dequeuing methods (offer, poll, remove() and add)
- linear time for the remove(Object) and contains(Object) methods
- constant time for the retrieval methods (peek, element, and size).


### hashMap
- key, value pair
- implement map interface
- permits null values and the null key.
- The HashMap class is roughly equivalent to Hashtable, except that it is unsynchronized and permits nulls.
- this implementation is not synchronized
- Uses a hash function to map keys to buckets; collisions are handled using linked lists or trees
- Load factor (default 0.75) determines when to resize
- This implementation provides constant-time performance for the basic operations (get and put), assuming the hash function disperses the elements properly among the buckets. Iteration over collection views requires time proportional to the "capacity" of the HashMap instance (the number of buckets) plus its size (the number of key-value mappings). Thus, it's very important not to set the initial capacity too high (or the load factor too low) if iteration performance is important.
- Map m = Collections.synchronizedMap(new HashMap(...));


### hashtable
- To successfully store and retrieve objects from a hashtable, the objects used as keys must implement the hashCode method and the equals method.
- Hashtable is synchronized
- Does not allow null keys or values

### hashset
- implement set interface
- Only stores values (no keys)
- permits the null element.
- This class offers constant time performance for the basic operations (add, remove, contains and size) 
- Note that this implementation is not synchronized.
- Permits one null element


### treeMap
- uses red-black tree
- map is sorted according to key or by comparator
- O(logn) for get, put remove operation
- not synchronized
- 

# Comparison of HashMap, HashSet, and Hashtable

| Feature       | HashMap      | HashSet      | Hashtable   |
|--------------|-------------|-------------|------------|
| **Interface** | Map         | Set         | Map        |
| **Thread Safety** | No         | No         | Yes        |
| **Null Keys** | Yes         | Yes (one)   | No         |
| **Null Values** | Yes         | N/A        | No         |
| **Performance** | Fastest     | Fast       | Slower (synchronized) |
| **Iteration Order** | No guarantee | No guarantee | No guarantee |
| **Internal Structure** | Hash table | Uses HashMap internally | Hash table |

# sorting algorithm
Algorithm        | Stable? | Notes  
--------------- | ------- | ----------------------------------------------  
Bubble Sort     | Yes     | Adjacent swaps preserve equal-element order  
Quick Sort      | No      | Pivot partitioning scrambles equal elements  
Merge Sort      | Yes     | Merging respects original order of equals  
Timsort (Java)  | Yes     | Built for stability in object sorting  
Insertion Sort  | Yes     | Insertion preserves relative positions  




Class           | Add            | Remove         | Search  
-------------- | -------------- | -------------- | --------------  
ArrayList      | O(1) amortized / O(n) at index | O(n) | O(n)  
LinkedList     | O(1) ends / O(n) at index | O(n) | O(n)  
Vector         | O(1) amortized / O(n) at index | O(n) | O(n)  
HashSet        | O(1) avg       | O(1) avg       | O(1) avg  
LinkedHashSet  | O(1) avg       | O(1) avg       | O(1) avg  
TreeSet        | O(log n)       | O(log n)       | O(log n)  
PriorityQueue  | O(log n)       | O(log n) head / O(n) object | O(n)  
ArrayDeque     | O(1) amortized | O(1) ends / O(n) object | O(n)  
HashMap        | O(1) avg       | O(1) avg       | O(1) avg  
LinkedHashMap  | O(1) avg       | O(1) avg       | O(1) avg  
TreeMap        | O(log n)       | O(log n)       | O(log n)  
Hashtable      | O(1) avg       | O(1) avg       | O(1) avg  











- Arrays.asList :- you can't add anything although you can set item
- List.of :- you can't do anything:- immutable

Map :- interface
HashedMap :- class 
  - store data in array of linked list
  - default 16
  - when linked list length reaches 8 then it is converted into red-black tree
  - not thread-safe
linkedHashMap :- store item in order manner 
  - store in doubly linked list
  - not thread-safe

- sortedMap :- interface
  - sorted based on keys
  - extends map

- hashtable
  - sychronized
  - no null or key
  - legacy class , replaced by concurrentHashMap
  - slower than HashMap


- remove in min-heap ---- O(logn)
- insertion in heap --- O(logn)

- getFirst -- retrieve first element if empty then exception
- getLast -- retrieve last element if empty than exception
- peekFirst -- retrieve first element if empty then null
- peekLast -- retrieve last element if empty then null


- blocking queue
  - thread safe
  - wait for queue to become non-empty / wait for space
  - producer and consumer




































key :- 1626 :- jay
okay : 1626 :- kartikey
key : 1626 : 