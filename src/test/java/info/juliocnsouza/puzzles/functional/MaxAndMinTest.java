package info.juliocnsouza.puzzles.functional;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaxAndMinTest {

    @Test
    public void testFindMax() {
        // fixture
        var input = Arrays.asList(1, 2, 3);
        var expected = 3;

        // test
        var result = MaxAndMin.findMax(input);

        // result
        assertEquals(expected, result);
    }

    @Test
    public void testFindMin() {
        // fixture
        var input = Arrays.asList(1, 2, 3);
        var expected = 1;

        // test
        var result = MaxAndMin.findMin(input);

        // result
        assertEquals(expected, result);
    }

}