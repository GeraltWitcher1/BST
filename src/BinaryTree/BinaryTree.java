package BinaryTree;

public class BinaryTree<E> {

    private BinaryTreeNode<E> root;
    private int size;

    public BinaryTree(BinaryTreeNode<E> root) {
        this.root = root;
        this.size = size();
    }

    public BinaryTreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<E> root) {
        this.root = root;
    }

    public int size() {
        this.size = size(root);
        return size;
    }

    private int size(BinaryTreeNode<E> node) {
        if (node == null)
            return 0;
        else return (size(node.getLeftChild()) + 1 + size(node.getRightChild()));
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int height() {
        return height(root);
    }

    int height(BinaryTreeNode<E> node) {
        if (node == null)
            return -1;
        else {
            int depthOfLeft = height(node.getLeftChild());
            int depthOfRight = height(node.getRightChild());

            if (depthOfLeft > depthOfRight)
                return (depthOfLeft + 1);
            else
                return (depthOfRight + 1);
        }
    }

    public boolean contains(E value){

        if(isEmpty())
            return false;

        return contains(root,value);
    }

    private boolean contains(BinaryTreeNode<E> node, E value) {
        if (node.getElement().equals(value)) {
            return true;
        }

        boolean isFound = false;
        if (node.getLeftChild()!=null) {
            isFound = contains(node.getLeftChild(), value);
        }
        if (!isFound && node.getRightChild()!=null) {
            isFound = contains(node.getRightChild(), value);
        }

        return isFound;
    }
}
