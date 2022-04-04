package BinarySearchTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    BinarySearchTree<Integer> testTree;

    @BeforeEach
    void setUp() {
        testTree = new BinarySearchTree<>(2);
    }

    @Test
    void insert() {
        assertTrue(testTree.insert(1));
        assertTrue(testTree.insert(3));

        Integer[] test = {1, 2, 3};
        ArrayList<Integer> expectedOrder = new ArrayList<>(Arrays.asList(test));

        assertEquals(expectedOrder, testTree.inOrder());

        testTree.insert(4);
        expectedOrder.add(4);

        assertEquals(expectedOrder, testTree.inOrder());
    }

    @Test
    void insertFalse() {
        assertTrue(testTree.insert(1));
        assertFalse(testTree.insert(1));
    }

    @Test
    void removeElement() {
        assertTrue(testTree.removeElement(2));
        assertFalse(testTree.contains(2));
    }

    @Test
    void removeElementFalse() {
        assertFalse(testTree.removeElement(3));
    }

    @Test
    void sizeZero() {
       testTree.removeElement(2);
       assertEquals(0, testTree.size());
    }

    @Test
    void sizeOne() {
        assertEquals(1, testTree.size());
    }

    @Test
    void sizeMany() {

        testTree.insert(1);
        testTree.insert(3);
        testTree.insert(4);
        testTree.insert(5);

        assertEquals(5, testTree.size());

        testTree.removeElement(5);

        assertEquals(4,testTree.size());
    }

    @Test
    void containsZero() {
        testTree.removeElement(2);
        assertFalse(testTree.contains(null));
    }

    @Test
    void containsOne() {
        assertTrue(testTree.contains(2));
    }

    @Test
    void containsMany() {

        testTree.insert(1);
        testTree.insert(3);
        testTree.insert(4);
        testTree.insert(5);

        assertTrue(testTree.contains(1));
        assertTrue(testTree.contains(5));
    }

    @Test
    void findMinZero() {
        testTree.removeElement(2);
        assertNull(testTree.findMin());
    }

    @Test
    void findMinOne() {
        assertEquals(2,testTree.findMin());
    }

    @Test
    void findMinMany() {

        testTree = new BinarySearchTree<>(5);
        testTree.insert(2);
        testTree.insert(1);
        testTree.insert(4);
        testTree.insert(6);
        testTree.insert(7);

        assertEquals(1,testTree.findMin());
    }

    @Test
    void findMaxZero() {
        testTree.removeElement(2);
        assertNull(testTree.findMax());
    }

    @Test
    void findMaxOne() {
        assertEquals(2,testTree.findMax());
    }

    @Test
    void findMaxMany() {

        testTree = new BinarySearchTree<>(5);
        testTree.insert(2);
        testTree.insert(1);
        testTree.insert(4);
        testTree.insert(7);
        testTree.insert(6);

        assertEquals(7,testTree.findMax());
    }

    @Test
    void rebalance() {
        testTree = new BinarySearchTree<>(5);
        testTree.insert(2);
        testTree.insert(1);
        testTree.insert(4);
        testTree.insert(7);
        testTree.insert(6);
        testTree.insert(8);
        testTree.insert(9);
        testTree.insert(10);
        testTree.insert(11);
        testTree.insert(12);

        testTree.rebalance();

        assertEquals(7,testTree.getRoot().getElement());
        assertEquals(3,testTree.height());

        Integer[] preOrderArr = {7,4,2,1,6,5,10,9,8,12,11};
        ArrayList<Integer> preOrderList = new ArrayList<>(Arrays.asList(preOrderArr));
        assertEquals(preOrderList,testTree.preOrder());
    }
}