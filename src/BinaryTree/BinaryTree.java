package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

    public boolean contains(E value) {

        if (isEmpty())
            return false;

        return contains(root, value);
    }

    private boolean contains(BinaryTreeNode<E> node, E value) {

        if (node.getElement().equals(value)) {
            return true;
        }

        boolean isFound = false;

        if (node.getLeftChild() != null) {
            isFound = contains(node.getLeftChild(), value);
        }

        if (!isFound && node.getRightChild() != null) {
            isFound = contains(node.getRightChild(), value);
        }

        return isFound;
    }

    public ArrayList<E> inOrder() {

        ArrayList<E> inOrder = new ArrayList<>();

        inOrder(root, inOrder);

        return inOrder;
    }

    private void inOrder(BinaryTreeNode<E> current, ArrayList<E> nodes) {
        if (current != null) {
            inOrder(current.getLeftChild(), nodes);
            nodes.add(current.getElement());
            inOrder(current.getRightChild(), nodes);
        }
    }

    public ArrayList<E> preOrder() {

        ArrayList<E> preOrder = new ArrayList<>();

        preOrder(root, preOrder);

        return preOrder;
    }

    private void preOrder(BinaryTreeNode<E> current, ArrayList<E> nodes) {
        if (current != null) {
            nodes.add(current.getElement());
            preOrder(current.getLeftChild(), nodes);
            preOrder(current.getRightChild(), nodes);
        }
    }

    public ArrayList<E> postOrder() {

        ArrayList<E> postOrder = new ArrayList<>();

        postOrder(root, postOrder);

        return postOrder;
    }

    private void postOrder(BinaryTreeNode<E> current, ArrayList<E> nodes) {
        if (current != null) {
            postOrder(current.getLeftChild(), nodes);
            postOrder(current.getRightChild(), nodes);
            nodes.add(current.getElement());
        }
    }


    public ArrayList<E> levelOrder() {

        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<E> levelOrder = new ArrayList<>();

        Queue<BinaryTreeNode<E>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            BinaryTreeNode<E> node = queue.remove();

            levelOrder.add(node.getElement());

            if (node.getLeftChild() != null) {
                queue.add(node.getLeftChild());
            }

            if (node.getRightChild() != null) {
                queue.add(node.getRightChild());
            }
        }
        return levelOrder;
    }


}
