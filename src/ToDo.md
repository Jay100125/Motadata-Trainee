Choosing the right collection: Be prepared to justify why you'd choose one collection over another for specific scenarios
Fail-fast vs. fail-safe iterators:

Fail-fast (most collections): Throw ConcurrentModificationException if modified during iteration
Fail-safe (concurrent collections): Work on a copy; won't throw exceptions but may not reflect latest state


Collection utility methods:

Collections.unmodifiableXxx for creating read-only views
Collections.synchronizedXxx for thread-safe wrappers
Collections.sort(), Collections.binarySearch(), etc.


Comparable vs. Comparator:

Comparable (natural ordering): implements compareTo() method
Comparator (custom ordering): separate class implementing compare()


Time/space complexity: Be prepared to discuss the performance implications of different operations