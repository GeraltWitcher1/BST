package BinaryTree;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class BinaryTreeNodeTest {

    BinaryTreeNode<Integer> testNode;

    @BeforeEach
    void setUp() {
        testNode = new BinaryTreeNode<Integer>(null);
    }

    @Test
    void setElement() {
        testNode.setElement(10);
        assertEquals(10, testNode.getElement());
    }

    @Test
    void getElement() {
        assertNull(testNode.getElement());
    }

    @Test
    void addLeftChild() {
        testNode.addLeftChild(new BinaryTreeNode<>(1));
        assertNotNull(testNode.getLeftChild());
        assertEquals(1, testNode.getLeftChild().getElement());
    }

    @Test
    void addRightChild() {
        testNode.addRightChild(new BinaryTreeNode<>(2));
        assertNotNull(testNode.getRightChild());
        assertEquals(2, testNode.getRightChild().getElement());
    }

    @Test
    void getLeftChild() {
        assertNull(testNode.getLeftChild());
        testNode.addLeftChild(new BinaryTreeNode<>(1));
        assertNotNull(testNode.getLeftChild());
    }

    @Test
    void getRightChild() {
        assertNull(testNode.getRightChild());
        testNode.addRightChild(new BinaryTreeNode<>(1));
        assertNotNull(testNode.getRightChild());
    }
}