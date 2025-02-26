# hashmap
- Internally, the key-value pairs are stored as an instance of Map.entry instances represented by Node. Each instance of Node class contains the supplied, key, value, the hash of the key object, and a reference to the next Node, if any, as in the LinkedList.

```java
static class Node<K,V> implements Map.Entry<K,V> {

  final int hash;
  final K key;
  V value;
  Node<K,V> next;

  //...
}

```

-the initial capacity of the HashMap, the default is 16.
