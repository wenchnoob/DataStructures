package PracticeAlgorithms;
import Linear.Stack;

public class ReverseAStack {
    public static void main(String[] args) {
        Stack<Comparable> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s);
        reverseStack(s, s.size(), 0);
        System.out.println(s);

    }

    public static void reverseStack(Stack<Comparable> s, int size, int depth) {
        if (depth < size/2) {
            Comparable c = s.pop();
            Comparable b = s.pop();
            reverseStack(s, size, depth+1);
            s.push(b);
            s.push(c);
        }
    }
}
