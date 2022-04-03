package BinaryTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

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

    @Test
    void testInOrder() {

        BinaryTreeNode<Integer> root = generateTree();
        testTree.setRoot(root);



        Integer[] test = {2,1,3};
        ArrayList<Integer> testInOrder = new ArrayList<>(Arrays.asList(test));
        ArrayList<Integer> actualOrder = testTree.inOrder();

        for (int i = 0; i < testInOrder.size()-1; i++) {
            assertEquals(testInOrder.get(i), actualOrder.get(i));
        }

        testTree.getRoot().getLeftChild().addLeftChild(new BinaryTreeNode<>(4));


        Integer[] test2 = {4,2,1,3};
        ArrayList<Integer> testInOrder2 = new ArrayList<>(Arrays.asList(test2));
        ArrayList<Integer> actualOrder2 = testTree.inOrder();

        for (int i = 0; i < testInOrder2.size()-1; i++) {
            assertEquals(testInOrder2.get(i), actualOrder2.get(i));
        }
    }

    @Test
    void tesPreOrder() {

        BinaryTreeNode<Integer> root = generateTree();
        testTree.setRoot(root);



        Integer[] test = {1,2,3};
        ArrayList<Integer> testPreOrder = new ArrayList<>(Arrays.asList(test));
        ArrayList<Integer> actualOrder = testTree.preOrder();

        for (int i = 0; i < testPreOrder.size()-1; i++) {
            assertEquals(testPreOrder.get(i), actualOrder.get(i));
        }

        testTree.getRoot().getLeftChild().addLeftChild(new BinaryTreeNode<>(4));


        Integer[] test2 = {1,2,4,3};
        ArrayList<Integer> testPreOrder2 = new ArrayList<>(Arrays.asList(test2));
        ArrayList<Integer> actualOrder2 = testTree.preOrder();

        for (int i = 0; i < testPreOrder2.size()-1; i++) {
            assertEquals(testPreOrder2.get(i), actualOrder2.get(i));
        }
    }

    @Test
    void testPostOrder() {

        BinaryTreeNode<Integer> root = generateTree();
        testTree.setRoot(root);



        Integer[] test = {2,3,1};
        ArrayList<Integer> testPostOrder = new ArrayList<>(Arrays.asList(test));
        ArrayList<Integer> actualOrder = testTree.postOrder();

        for (int i = 0; i < testPostOrder.size()-1; i++) {
            assertEquals(testPostOrder.get(i), actualOrder.get(i));
        }

        testTree.getRoot().getLeftChild().addLeftChild(new BinaryTreeNode<>(4));


        Integer[] test2 = {4,2,3,1};
        ArrayList<Integer> testInOrder2 = new ArrayList<>(Arrays.asList(test2));
        ArrayList<Integer> actualOrder2 = testTree.postOrder();

        for (int i = 0; i < testInOrder2.size()-1; i++) {
            assertEquals(testInOrder2.get(i), actualOrder2.get(i));
        }
    }

    @Test
    void testLevelOrder() {

        BinaryTreeNode<Integer> root = generateTree();
        testTree.setRoot(root);



        Integer[] test = {1,2,3};
        ArrayList<Integer> testLevelOrder = new ArrayList<>(Arrays.asList(test));
        ArrayList<Integer> actualOrder = testTree.levelOrder();

        for (int i = 0; i < testLevelOrder.size()-1; i++) {
            assertEquals(testLevelOrder.get(i), actualOrder.get(i));
        }

        testTree.getRoot().getLeftChild().addLeftChild(new BinaryTreeNode<>(4));


        Integer[] test2 = {1,2,3,4};
        ArrayList<Integer> testLevelOrder2 = new ArrayList<>(Arrays.asList(test2));
        ArrayList<Integer> actualOrder2 = testTree.levelOrder();

        for (int i = 0; i < testLevelOrder2.size()-1; i++) {
            assertEquals(testLevelOrder2.get(i), actualOrder2.get(i));
        }
    }
}