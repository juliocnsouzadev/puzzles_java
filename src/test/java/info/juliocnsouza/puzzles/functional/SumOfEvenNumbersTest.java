package info.juliocnsouza.puzzles.functional;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SumOfEvenNumbersTest {

    @Test
    public void testSumOfEven() {
        //fixture
        final int expected = 6;
        final List<Integer> input = Arrays.asList(1, 2, 3, 4);

        //test
        final int resultMethodRef = SumOfEvenNumbers.sumOfEven(input);
        final int resultLambda = SumOfEvenNumbers.sumOfEvenLambda(input);

        //assertions
        assertEquals(expected, resultMethodRef);
        assertEquals(expected, resultLambda);
    }

}