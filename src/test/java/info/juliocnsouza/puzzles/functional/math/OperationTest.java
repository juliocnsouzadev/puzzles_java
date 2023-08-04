package info.juliocnsouza.puzzles.functional.math;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    @Test
    void testSum() {
        // fixture
        var data = Arrays.asList( 1, 2, 3, 4, 5 );
        var sum = new MathOperations().sum();
        var expected = 15;

        // test
        var result = getReduce(data, sum);

        assertEquals(expected, result );
    }

    void testSubtract() {
        // fixture
        var data = Arrays.asList( 1, 2, 3, 4, 5 );
        var subtract = new MathOperations().subtract();
        var expected = -13;

        // test
        var result = getReduce(data, subtract);

        assertEquals(expected, result );
    }

    private static Integer getReduce(List<Integer> data, Operation sum) {
        return data.stream().reduce(0, sum::apply);
    }

}