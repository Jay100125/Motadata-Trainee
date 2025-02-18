package generics;
// pure compile time feature
// compiler do :-  type erasure :- T replace by object in bytecode
//              Explicit casting

// cannot be used in static manner
// can't use primitive value

// raw type :- Container stringStore
// compile-time type safety is lost
// why is raw type supported - interoperate with legacy code
// uses of raw type :- class literal
                // instanceOf operator

//unbounded wildcard type argument


public class GenericsDemo {
    public static void main(String[] args) {
        Container<String> stringStore = new Store<>();
        stringStore.set("Java");
        // stringStore.set(1)
        System.out.println(stringStore.get());
    }
}

interface Container<T>
{
    void set(T a);
    T get();
}

class Store<T> implements Container<T>{
    private T a;

    public void set(T a)
    {
        this.a = a;
    }

    public T get(){
        return this.a;
    }
}
