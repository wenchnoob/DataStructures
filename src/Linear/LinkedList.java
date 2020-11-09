package Linear;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public LinkedList(T...args) {
        for (T t: args) {
            this.add(t);
        }
    }

    public int size() { return size; }

    public void add(T val) {
        if (val == null) throw new java.lang.IllegalArgumentException("This linkedlist does not support null elements.");
        if(head == null) {
            tail = new Node(val);
            head = tail;
        } else {
            tail.next = new Node(val);
            tail = tail.next;
        }
        size++;
    }

    public T remove(int i) {
        if (i > size) throw new java.lang.IndexOutOfBoundsException("Index to be removed is greater than size of the linkedlist.");

        int j = 1;
        Node<T> temp = head;
        while(++j < i) {
            temp = temp.next;
        }

        T toReturn = temp.val;
        temp.next = temp.next.next;

        return toReturn;
    }

    public void reverse() {
        if(size <= 1) return;
        reverse(null, head, head.next);
        Node<T> temp = head;
        head = tail;
        tail = temp;
    }
    private void reverse(Node<T> prevNode, Node<T> curNode, Node<T> nextNode) {
        if(nextNode != null) {
            curNode.next = prevNode;
            reverse(curNode, nextNode, nextNode.next);
        } else if (nextNode == null && curNode != null) {
            curNode.next = prevNode;
        }
    }

    public boolean isEmpty() {
        if (size == 0) return true;
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
        private Node<T> temp = head;

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
        LinkedList<Integer> ll = new LinkedList<>( 3, 12, 42, 23, 43, 234, 3224);
        System.out.println(ll.remove(4));
        ll.reverse();
        System.out.println(ll);
    }
}

class Node<T> {
    public T val;
    public Node<T> next;

    public Node(T val, Node<T> next) {
        this.val = val;
        this.next = next;
    }

    public Node(T val) {
        this(val, null);
    }
}
