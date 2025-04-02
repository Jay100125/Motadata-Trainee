## jcmd
- heap dump

1. print system properties
```java
jcmd <pid> VM.system_properties
```

2. force gc
```java
jcmd <pid> GC.run
```

3. heapdump
```java
jcmd <pid> GC.heap_dump <filename>
```

4. get Thread dump
```java
jcmd <pid> Thread.print
```

5. Uptime
```java
jcmd <pid> VM.uptime
```

6. flags
```java
jcmd <pid> VM.version
```




