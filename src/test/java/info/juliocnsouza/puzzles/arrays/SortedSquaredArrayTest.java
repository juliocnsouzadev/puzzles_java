package info.juliocnsouza.puzzles.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class SortedSquaredArrayTest {

    @Test
    @DisplayName("Given a non-empty array of integers that are sorted\n" +
            "  in ascending order should return a new array of the same length with the squares\n" +
            "  of the original integers also sorted in ascending order.")
    void sortAndSquare() {
        // Fixtures
        final Random random = new Random();

        final int size = 100;
        final int[] givenArray = new int[size];
        for (int i = 0; i < size; i++) {
            final int number = random.nextInt(1000);
            givenArray[i] = random.nextBoolean() ? number : number * -1;
        }
        Arrays.sort(givenArray);

        // expectations
        final int[] expectedArray = Arrays.copyOf(givenArray, size);
        for (int i = 0; i < expectedArray.length; i++) {
            expectedArray[i] = expectedArray[i] * expectedArray[i];
        }
        Arrays.sort(expectedArray);

        // Tests
        final SortedSquaredArray sortedSquaredArray = new SortedSquaredArray();
        final int[] result = sortedSquaredArray.sortAndSquare(givenArray);

        assertThat(result).containsExactly(expectedArray);

    }
}