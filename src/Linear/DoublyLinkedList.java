package Linear;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {
    private DoubleLinkNode<T> head;
    private DoubleLinkNode<T> tail;
    private int size = 0;

    public DoublyLinkedList(T...args) {
        for (T t: args) {
            this.addBack(t);
        }
    }

    public int size() { return size; }

    public void addFront(T val) {
        if (val == null) throw new IllegalArgumentException("This linkedlist does not support null elements.");
        if(head == null) {
            tail = new DoubleLinkNode<>(val);
            head = tail;
        } else {
            DoubleLinkNode<T> temp = head;
            head = new DoubleLinkNode<>(val, temp, null);
        }
        size++;
    }

    public void addBack(T val) {
        if (val == null) throw new IllegalArgumentException("This linkedlist does not support null elements.");
        if(head == null) {
            tail = new DoubleLinkNode<>(val);
            head = tail;
        } else {
            tail.next = new DoubleLinkNode<T>(val, null, tail);
            tail = tail.next;
        }
        size++;
    }

    public T remove(int i) {
        if (i > size || i < 0 || isEmpty())
            throw new IndexOutOfBoundsException("Index to be removed is outside of the range of the linkedlist.");

        int j = 1;
        DoubleLinkNode<T> temp = head;
        while(++j < i) {
            temp = temp.next;
        }

        T toReturn = temp.val;
        temp.next = temp.next.next;
        size--;
        return toReturn;
    }

    public T removeFront() {
        if (isEmpty()) throw new IllegalStateException("LinkedList is empty");

        T toReturn = head.val;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return toReturn;
    }

    public T removeBack() {
        if (isEmpty()) throw new IllegalStateException("LinkedList is empty");

        T toReturn = tail.val;
        if (size == 1) head = null;
        tail = null;
        size--;
        return toReturn;
    }

    public boolean isEmpty() {
        if (size <= 0) return true;
        return false;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        Iterator<T> iter = this.iterator();
        while(iter.hasNext()) sb.append(iter.next() + "-> ");
        sb.append("null");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() { return new Itertool(); }

    private class Itertool implements Iterator {
        private DoubleLinkNode<T> temp = head;

        @Override
        public boolean hasNext() {
            if (temp == null) return false;
            return true;
        }

        @Override
        public T next() {
            T val = temp.val;
            temp = temp.next;
            return val;
        }
    }

    // For unit testing of the class :)
    public static void main(String[] args) {
        DoublyLinkedList<Integer> ll = new DoublyLinkedList<>( 3);
        System.out.println(ll.size());
        System.out.println(ll.removeFront());
        System.out.println(ll.size());
        //ll.removeFront();
        ll.addFront(12);
        System.out.println(ll);
    }
}

class DoubleLinkNode<T> {
    public T val;
    public DoubleLinkNode<T> next;
    public DoubleLinkNode<T> prev;

    public DoubleLinkNode(T val, DoubleLinkNode<T> next, DoubleLinkNode<T> prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    public DoubleLinkNode(T val) {
        this(val, null, null);
    }
    public DoubleLinkNode(T val, DoubleLinkNode<T> prev) { this(val, null, prev); }
}
