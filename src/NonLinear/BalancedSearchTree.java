package NonLinear;

public class BalancedSearchTree<V extends Comparable<V>>  {
    TreeNode<V> root;





}

class ColoredTreeNode<V extends Comparable<V>> {
    public TreeNode<V> parent;
    public TreeNode<V> left;
    public TreeNode<V> right;
    public boolean red = false;

    public V val;

    public ColoredTreeNode(V val, TreeNode<V> parent) {
        this.val = val;
        this.parent = parent;
    }
}
