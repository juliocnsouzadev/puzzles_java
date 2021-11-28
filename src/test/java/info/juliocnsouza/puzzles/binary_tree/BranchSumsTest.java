package info.juliocnsouza.puzzles.binary_tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BranchSumsTest {

    @Test
    void branchSums() {
        // fixtures
        final BinaryTree tree = BinaryTree
                .builder(1)
                .left(BinaryTree
                        .builder(2)
                        .left(BinaryTree
                                .builder(4)
                                .left(BinaryTree.builder(8))
                                .right(BinaryTree.builder(9))
                        )
                        .right(BinaryTree
                                .builder(5)
                                .left(BinaryTree.builder(10))
                        )
                )
                .right(BinaryTree
                        .builder(3)
                        .left(BinaryTree.builder(6))
                        .right(BinaryTree.builder(7))
                );

        // expected
        final List<Integer> expected = List.of(15, 16, 18, 10, 11);

        // tests
        final BranchSums branchSums = new BranchSums();
        final List<Integer> result = branchSums.branchSums(tree);

        // assertions
        assertEquals(expected, result);
    }
}