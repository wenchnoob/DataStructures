package Linear;

import java.util.Iterator;

public class Queue<T> {
    private DoublyLinkedList<T> doublyll = new DoublyLinkedList<>();

    public Queue(T...args) {
        for (T t: args) {
            enqueue(t);
        }
    }

    public void enqueue(T val) {
        doublyll.addBack(val);
    }

    public T dequeue() {
        return doublyll.removeFront();
    }

    public int size() { return doublyll.size(); }
    public boolean isEmpty() { return doublyll.isEmpty(); }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        Iterator<T> iter = doublyll.iterator();
        while(iter.hasNext()) sb.append(" <- " + iter.next());
        return sb.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        q.enqueue(12);
        q.dequeue();
        q.dequeue();
        System.out.println(q);

    }
}
