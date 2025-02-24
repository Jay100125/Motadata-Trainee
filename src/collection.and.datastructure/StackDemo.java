package collection.and.datastructure;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.ListIterator;

class ArrayStack{
    private Employee[] stack;
    private int top;

    public ArrayStack(int capacity){
        stack = new Employee[capacity];
    }

    public void push(Employee e){
        if(top == stack.length){
            // need to resize
            Employee[] newStack = new Employee[stack.length*2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }

        stack[top++] = e;
    }

    public Employee pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }

        Employee e = stack[--top];
        stack[top] = null;
        return e;
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public Employee peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stack[top-1];
    }

    public void display(){
        for(int i = top-1; i >= 0; i--){
            Employee e = stack[i];
            System.out.println(e);
        }
    }
}

class LinkedStack{
    private LinkedList<Employee> stack;

    public LinkedStack(){
        stack = new LinkedList<Employee>();
    }

    public void push(Employee e){
        stack.push(e);
    }

    public Employee pop(){
        return stack.pop();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public Employee peek(){
        return stack.peek();
    }

    public void printStack() {

        ListIterator<Employee> iterator = stack.listIterator();

        while (iterator.hasNext()) {

            System.out.println(iterator.next());
        }
    }
}
public class StackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(10);
        stack.push(new Employee(1, "Alex"));
        stack.push(new Employee(2, "Bob"));
        stack.push(new Employee(3, "Carl"));
        stack.display();

        stack.pop();
        stack.display();

//        stack.pop();
//        stack.display();
//
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());

        System.out.println("_________________________________________-");

        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push(new Employee(1, "Alex"));
        linkedStack.push(new Employee(2, "Bob"));
        linkedStack.push(new Employee(3, "Carl"));
        linkedStack.printStack();

        linkedStack.pop();
        linkedStack.printStack();

        System.out.println(linkedStack.peek());
        System.out.println(linkedStack.isEmpty());
        System.out.println(linkedStack.pop());
        linkedStack.printStack();


    }
}
