package info.juliocnsouza.puzzles.arrays;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpiralTraverseTest {

    @Test
    void testSpiralTraverse() {
        // fixture
        var input = new int[][]{
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };

        var expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);

        // test
        var result = SpiralTraverse.spiralTraverse(input);

        // assertions
        assertEquals(expected, result);
    }
}