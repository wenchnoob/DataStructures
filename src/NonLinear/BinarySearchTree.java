package NonLinear;

import java.util.Iterator;
import Linear.Stack;

public class BinarySearchTree<V extends Comparable<V>> implements Iterable<V> {
    TreeNode<V> root;

    public BinarySearchTree() { }

    public void insert(V val) {
        if (root == null) {
            root = new TreeNode<>(val, null);
        } else {
            insert(val, root);
        }
    }

    private void insert(V val, TreeNode<V> parent) {
        if(parent.val.compareTo(val) < 0) {
            if(parent.right == null) {
                parent.right = new TreeNode<>(val, parent);
            } else {
                insert(val, parent.right);
            }
        } else {
            if(parent.left == null) {
                parent.left = new TreeNode<>(val, parent);
            } else {
                insert(val, parent.left);
            }
        }
    }

    public boolean search(V val) {
        return search(val, root);
    }

    private boolean search(V val, TreeNode<V> node) {
        if (node.val.compareTo(val) == 0) return true;
        if (node.val.compareTo(val) < 0 && node.right != null) return search(val, node.right);
        else if (node.val.compareTo(val) > 0 && node.left != null) return search(val, node.left);
        return false;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        Iterator<V> iter = this.iterator();
        while(iter.hasNext()) sb.append(iter.next() + " ");
        return sb.toString();
    }

    @Override
    public Iterator<V> iterator() {
        return new Itertool();
    }

    private class Itertool implements Iterator<V> {
        private Stack<V> s = new Stack<>();

        public Itertool() {
            inorder();
        }

        // traverses the tree from the rightmost node to the leftmost node (actually reverse inorder traversal)
        private void inorder() {
            inorder(root);
        }

        private void inorder(TreeNode<V> node) {
            if (node.right != null) inorder(node.right);
            s.push(node.val);
            if (node.left != null) inorder(node.left);
        }

        @Override
        public boolean hasNext() {
            return !s.isEmpty();
        }

        @Override
        public V next() {
            return s.pop();
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(20);
        bst.insert(5);
        bst.insert(35);
        bst.insert(10);
        bst.insert(20);
        bst.insert(5);
        bst.insert(35);

        System.out.println(bst);

        System.out.println(bst.search(20));
        System.out.println(bst.search(585));
    }

}

class TreeNode<V extends Comparable<V>> {
    public TreeNode<V> parent;
    public TreeNode<V> left;
    public TreeNode<V> right;

    public V val;

    public TreeNode(V val, TreeNode<V> parent) {
        this.val = val;
        this.parent = parent;
    }
}
