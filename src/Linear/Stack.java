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
        while(iter.hasNext()) sb.append(" >- " + iter.next());
        return this.reverse(sb.toString());
    }

    private String reverse(String s) {
        if (s == null || s.length() - 1 == 0) return s;
        return s.charAt(s.length() - 1) + reverse(s.substring(0, s.length() - 1));
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        s.pop();
        s.pop();
        s.pop();
        System.out.println(s);
    }
}
