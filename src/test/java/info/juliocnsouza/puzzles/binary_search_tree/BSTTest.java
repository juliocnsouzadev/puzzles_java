package info.juliocnsouza.puzzles.binary_search_tree;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BSTTest {

    @Test
    public void testInsert_HappyPath() {
        BST tree = new BST(5);
        tree.insert(3);
        tree.insert(7);

        assertTrue(tree.contains(3));
        assertTrue(tree.contains(7));
    }

    @Test
    public void testContains_HappyPath() {
        BST tree = new BST(5);
        tree.insert(3);
        assertTrue(tree.contains(3));
        assertFalse(tree.contains(10));
    }

    @Test
    public void testRemove_HappyPath() {
        BST tree = new BST(5);
        tree.insert(1);//l
        tree.insert(6);//r
        tree.insert(3);//l r
        tree.insert(7);//r r

        tree.remove(3);

        assertFalse(tree.contains(3));
    }

    @Test
    public void testInsert_EdgeCase() {
        BST tree = new BST(5);
        tree.insert(5);
        assertTrue(tree.contains(5));
        // Note: The behavior when inserting null or duplicate values depends on the BST implementation.
        // This is just a stub and might need adjustments based on your BST's behavior.
    }

    @Test
    public void testContains_EdgeCase() {
        BST tree = new BST(5);
        assertFalse(tree.contains(10));
        // Again, the behavior when searching for null values depends on your BST's behavior.
    }

    @Test
    public void testRemove_EdgeCase() {
        BST tree = new BST(5);
        tree.remove(10);
        assertTrue(tree.contains(5)); // Ensure the original node is still there.
        // The behavior when removing non-existent or null values depends on your BST's behavior.
    }

    @Test
    public void testUnhappyPaths() {
        BST tree = new BST(5);
        // Here, you can test any other scenarios where you expect the BST to behave in an unexpected manner.
        // For example, trying to remove a node from an empty tree, or any other edge cases you can think of.
    }
}

// Note: You'll need an actual implementation of the BST (e.g., BST) to run these tests. 
// The tests are written based on the assumption that the BST class extends the provided BST class.
