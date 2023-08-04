package info.juliocnsouza.puzzles.functional;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SquareAndCollectTest {
    @Test
    public void testSquareAndCollect() {
        // fixture
        final List<Integer> expected = Arrays.asList(1, 4, 9);
        final List<Integer> input = Arrays.asList(1, 2, 3);

        // test
        final List<Integer> result = SquareAndCollect.squareAndCollect(input);

        // assertion
        assertEquals(expected, result);
    }
}