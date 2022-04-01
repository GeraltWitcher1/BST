package BinaryTree;

public class BinaryTreeNode<E> {

    private E element;

    private BinaryTreeNode<E> left;
    private BinaryTreeNode<E> right;

    public BinaryTreeNode(E element) {
        setElement(element);
        left = null;
        right = null;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public void addLeftChild(BinaryTreeNode<E> node) {
        this.left = node;
    }

    public void addRightChild(BinaryTreeNode<E> node) {
        this.right = node;
    }

    public BinaryTreeNode<E> getLeftChild() {
        return left;
    }

    public BinaryTreeNode<E> getRightChild() {
        return right;
    }
}
