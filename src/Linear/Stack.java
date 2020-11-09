package Linear;

import java.util.Iterator;

public class Stack<T> {

    private DoublyLinkedList<T> doublyll = new DoublyLinkedList<>();

    public Stack(T...args) {
        for (T t: args) {
            push(t);
        }
    }


    public void push(T val) {
        doublyll.addFront(val);
    }

    public T pop() {
        return doublyll.removeFront();
    }

    public int size() { return doublyll.size(); }
    public boolean isEmpty() { return doublyll.isEmpty(); }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        Iterator<T> iter = doublyll.iterator();
        Stack<String> s = new Stack<>();
        while(iter.hasNext()) s.push(iter.next().toString());
        while(!s.isEmpty()) sb.append(s.pop() + " -> ");
        return sb.toString();
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        s.pop();
        s.pop();
        s.pop();
        System.out.println(s);
    }
}
