package info.juliocnsouza.puzzles.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmallestDifferenceTest {

    @Test
    void execute() {
        // fixtures
        final SmallestDifference smallestDifference = new SmallestDifference();

        int[] arg1 = {-1,5,10,28,3};
        int[] arg2 = {26,134,135,15,17};

        // expectations
        int expectedOutput[] = {28,26};

        //test
        final int[] result = smallestDifference.execute(arg1, arg2);

        //assertions
        assertArrayEquals(expectedOutput, result);
    }
}