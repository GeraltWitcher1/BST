package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E> {

    private BinaryTreeNode<E> root;

    public BinaryTree(BinaryTreeNode<E> root) {
        this.root = root;
    }

    public BinaryTreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<E> root) {
        this.root = root;
    }

    public int size() {
        return size(root);
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

        return containsRecursive(root, value);
    }

    private boolean containsRecursive(BinaryTreeNode<E> node, E value) {

        if (node.getElement().equals(value)) {
            return true;
        }

        boolean isFound = false;

        if (node.getLeftChild() != null) {
            isFound = containsRecursive(node.getLeftChild(), value);
        }

        if (!isFound && node.getRightChild() != null) {
            isFound = containsRecursive(node.getRightChild(), value);
        }

        return isFound;
    }

    public ArrayList<E> inOrder() {

        ArrayList<E> inOrder = new ArrayList<>();

        inOrderRecursive(root, inOrder);

        return inOrder;
    }

    private void inOrderRecursive(BinaryTreeNode<E> current, ArrayList<E> nodes) {
        if (current != null) {
            inOrderRecursive(current.getLeftChild(), nodes);
            nodes.add(current.getElement());
            inOrderRecursive(current.getRightChild(), nodes);
        }
    }

    public ArrayList<E> preOrder() {

        ArrayList<E> preOrder = new ArrayList<>();

        preOrderRecursive(root, preOrder);

        return preOrder;
    }

    private void preOrderRecursive(BinaryTreeNode<E> current, ArrayList<E> nodes) {
        if (current != null) {
            nodes.add(current.getElement());
            preOrderRecursive(current.getLeftChild(), nodes);
            preOrderRecursive(current.getRightChild(), nodes);
        }
    }

    public ArrayList<E> postOrder() {

        ArrayList<E> postOrder = new ArrayList<>();

        postOrderRecursive(root, postOrder);

        return postOrder;
    }

    private void postOrderRecursive(BinaryTreeNode<E> current, ArrayList<E> nodes) {
        if (current != null) {
            postOrderRecursive(current.getLeftChild(), nodes);
            postOrderRecursive(current.getRightChild(), nodes);
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
