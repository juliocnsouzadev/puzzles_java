package info.juliocnsouza.puzzles.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ArraysOfProductsTest {

    @Test
    void arrayOfProducts() {
        // fixture
        var instance = new ArraysOfProducts();
        List.of(
                addCase(List.of(5, 1, 4, 2), List.of(8, 40, 10, 20))
        ).forEach(testCase -> {
            // test
            var result = instance.arrayOfProducts(testCase.input);

            // assert
            Assertions.assertArrayEquals(testCase.expected, result);
        });
    }

    private static TestCase addCase(List<Integer> input, List<Integer> expected) {
        return new TestCase(input, expected);
    }

    private static class TestCase {
        int[] input;
        int[] expected;

        TestCase(List<Integer> input, List<Integer> expected) {
            this.input = input.stream().mapToInt(item -> item).toArray();
            this.expected = expected.stream().mapToInt(item -> item).toArray();
        }
    }
}