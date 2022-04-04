package BinarySearchTree;

import BinaryTree.BinaryTree;
import BinaryTree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

    private int size;

    public BinarySearchTree(BinaryTreeNode<E> root) {
        super(root);
        this.size = 1;
    }

    public BinarySearchTree(E element) {
        this(new BinaryTreeNode<>(element));
    }

    public boolean insert(E element) {

        if (contains(element))
            return false;

        super.setRoot(insertRecursive(super.getRoot(), element));
        this.size++;
        return true;
    }

    private BinaryTreeNode<E> insertRecursive(BinaryTreeNode<E> node, E element) {

        if (node == null)
            return new BinaryTreeNode<>(element);

        if (element.compareTo(node.getElement()) < 0)
            node.addLeftChild(insertRecursive(node.getLeftChild(), element));
        else if (element.compareTo(node.getElement()) > 0)
            node.addRightChild(insertRecursive(node.getRightChild(), element));

        return node;

    }

    public boolean removeElement(E element) {

        if(!contains(element))
            return false;

        super.setRoot(removeElementRecursive(super.getRoot(), element));
        this.size--;
        return true;

    }

    private BinaryTreeNode<E> removeElementRecursive(BinaryTreeNode<E> node, E element) {

        if (node == null) {
            return null;
        }

        //found element to delete
        if (element.equals(node.getElement())) {

            // 0 children
            if (node.getLeftChild() == null && node.getRightChild() == null)
                return null;

            // 1 child
            if (node.getLeftChild() == null)
                return node.getRightChild();
            else if (node.getRightChild() == null)
                return node.getLeftChild();

            // 2 children
            BinaryTreeNode<E> successor = findMinRecursive(node.getRightChild());
            node.setElement(successor.getElement());
            node.addRightChild(removeElementRecursive(node.getRightChild(), successor.getElement()));
            return node;
        }

        //traversing to find the element
        if (element.compareTo(node.getElement()) < 0) {
            node.addLeftChild(removeElementRecursive(node.getLeftChild(), element));
            return node;
        }

        node.addRightChild(removeElementRecursive(node.getRightChild(), element));
        return node;
    }

    public E findMin() {

        if (isEmpty())
            return null;

        return findMinRecursive(super.getRoot()).getElement();
    }

    private BinaryTreeNode<E> findMinRecursive(BinaryTreeNode<E> root) {
        return root.getLeftChild() == null ? root : findMinRecursive(root.getLeftChild());
    }

    public E findMax() {

        if (isEmpty())
            return null;

        return findMaxRecursive(super.getRoot()).getElement();
    }

    private BinaryTreeNode<E> findMaxRecursive(BinaryTreeNode<E> root) {
        return root.getRightChild() == null ? root : findMaxRecursive(root.getRightChild());
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(E value) {
        return containsRecursive(super.getRoot(), value);
    }

    private boolean containsRecursive(BinaryTreeNode<E> node, E value) {

        if (node == null)
            return false;

        if (node.getElement().equals(value))
            return true;

        return value.compareTo(node.getElement()) > 0
                ? containsRecursive(node.getRightChild(), value)
                : containsRecursive(node.getLeftChild(), value);

    }

    public void rebalance() {
        super.setRoot(rebalanceRecursive(super.inOrder()));
    }

    private BinaryTreeNode<E> rebalanceRecursive(List<E> nodes) {

        if(nodes==null || nodes.isEmpty())
            return null;

        int middleIndex = nodes.size()/2;
        E middleElement = nodes.get(middleIndex);
        BinaryTreeNode<E> middleNode = new BinaryTreeNode<>(middleElement);

        middleNode.addLeftChild(rebalanceRecursive(nodes.subList(0,middleIndex)));
        middleNode.addRightChild(rebalanceRecursive(nodes.subList(middleIndex+1,nodes.size())));
        return middleNode;

    }


}
