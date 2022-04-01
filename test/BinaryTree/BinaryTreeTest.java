package BinaryTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    BinaryTree<Integer> testTree;

    @BeforeEach
    void setUp() {
        testTree = new BinaryTree<Integer>(null);
    }

    private BinaryTreeNode<Integer> generateTree(){

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);

        root.addLeftChild(new BinaryTreeNode<>(2));
        root.addRightChild(new BinaryTreeNode<>(3));

        return root;
    }


    @Test
    void getRoot() {
        assertNull(testTree.getRoot());
        testTree.setRoot(new BinaryTreeNode<>(1));
        assertNotNull(testTree.getRoot());
    }

    @Test
    void setRoot() {
        testTree.setRoot(new BinaryTreeNode<>(1));
        assertEquals(1, testTree.getRoot().getElement());
    }

    @Test
    void isEmpty() {
        assertTrue(testTree.isEmpty());
        testTree.setRoot(new BinaryTreeNode<>(1));
        assertFalse(testTree.isEmpty());
    }

    @Test
    void getSizeZero() {
        assertEquals(0, testTree.size());
    }

    @Test
    void getSizeOne() {
        testTree.setRoot(new BinaryTreeNode<>(1));
        assertEquals(1, testTree.size());
    }

    @Test
    void getSizeMany() {

        BinaryTreeNode<Integer> root = generateTree();
        testTree.setRoot(root);

        assertEquals(3, testTree.size());
    }

    @Test
    void testHeightZero() {
        assertEquals(-1, testTree.height());
    }

    @Test
    void testHeightOne() {
        testTree.setRoot(new BinaryTreeNode<>(1));
        assertEquals(0, testTree.height());
    }

    @Test
    void testHeightMany() {

        BinaryTreeNode<Integer> root = generateTree();
        testTree.setRoot(root);

        assertEquals(1, testTree.height());

        root.getLeftChild().addLeftChild(new BinaryTreeNode<>(4));

        assertEquals(2, testTree.height());
    }

    @Test
    void testContainsZero() {
        assertFalse(testTree.contains(null));
    }

    @Test
    void testContainsOne() {
        testTree.setRoot(new BinaryTreeNode<>(1));
        assertTrue(testTree.contains(1));
    }

    @Test
    void testContainsMany() {

        BinaryTreeNode<Integer> root = generateTree();
        testTree.setRoot(root);

        assertTrue(testTree.contains(2));

        testTree.getRoot().getLeftChild().addLeftChild(new BinaryTreeNode<>(4));

        assertTrue(testTree.contains(4));
    }
}