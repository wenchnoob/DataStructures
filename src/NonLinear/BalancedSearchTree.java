package NonLinear;

// Cannot get enough information on when to apply the rotations on the tree
// So I will wait to implement it, because I honestly do not get it right now.

public class BalancedSearchTree<V extends Comparable<V>>  {
    ColoredTreeNode<V> root;

    public void insert(V val) {
        if (root == null) {
            root = new ColoredTreeNode<>(val, null);
        } else {
            insert(val, root);
        }
    }

    private void insert(V val,ColoredTreeNode<V> parent) {
        if(parent.val.compareTo(val) < 0) {
            if(parent.right == null) {
                parent.right = new ColoredTreeNode<>(val, parent);
            } else {
                insert(val, parent.right);
            }
        } else {
            if(parent.left == null) {
                parent.left = new ColoredTreeNode<>(val, parent);
            } else {
                insert(val, parent.left);
            }
        }
    }



}

class ColoredTreeNode<V extends Comparable<V>> {
    public ColoredTreeNode<V> parent;
    public ColoredTreeNode<V> left;
    public ColoredTreeNode<V> right;
    public boolean red = false;

    public V val;

    public ColoredTreeNode(V val, ColoredTreeNode<V> parent) {
        this.val = val;
        this.parent = parent;
    }
}
