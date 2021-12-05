package info.juliocnsouza.puzzles.binary_tree;

import org.junit.jupiter.api.Test;

import static info.juliocnsouza.puzzles.binary_tree.BinaryTree.builder;
import static org.junit.jupiter.api.Assertions.*;

class NodeDepthsTest {

    @Test
    void nodeDepths() {
        // fixtures
        final BinaryTree root = builder(1)
                .left(builder(2)
                        .left(builder(4)
                                .left(builder(8))
                                .right(builder(9))
                        )
                        .right(builder(5))
                )
                .right(builder(3)
                        .left(builder(6))
                        .right(builder(7))
                );

        // expected output
        int expected = 16;

        // test
        final int result = new NodeDepths().nodeDepths(root);

        // assertions
        assertEquals(expected, result);

    }
}