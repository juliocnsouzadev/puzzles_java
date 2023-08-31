package info.juliocnsouza.puzzles.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ArraysOfProductsTest {

    public static final List<TestCase> TEST_CASES = List.of(
            addCase(List.of(5, 1, 4, 2), List.of(8, 40, 10, 20)),
            addCase(List.of(0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9), List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)),
            addCase(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), List.of(362880, 0, 0, 0, 0, 0, 0, 0, 0, 0))
    );
    private final ArraysOfProducts brutalForce = new ArraysOfProducts();
    private final ArraysOfProductsUsesDivision withDivision = new ArraysOfProductsUsesDivision();

    private static TestCase addCase(List<Integer> input, List<Integer> expected) {
        return new TestCase(input, expected);
    }

    @Test
    void arrayOfProducts() {

        TEST_CASES.forEach(testCase -> {
            // test
            var resultA = brutalForce.arrayOfProducts(testCase.input);
            var resultB = withDivision.arrayOfProducts(testCase.input);

            // assert
            Assertions.assertArrayEquals(testCase.expected, resultA);
            Assertions.assertArrayEquals(testCase.expected, resultB);
        });
    }

    @Test
    void arrayOfProductsPerformance() {
        final int loops = 10000000;
        var start = Calendar.getInstance();
        for (int i = 0; i < loops; i++) {
            TEST_CASES.forEach(testCase -> brutalForce.arrayOfProducts(testCase.input));
        }
        var end = Calendar.getInstance();

        double aTime = end.getTimeInMillis() - start.getTimeInMillis();

        start = Calendar.getInstance();
        for (int i = 0; i < loops; i++) {
            TEST_CASES.forEach(testCase -> withDivision.arrayOfProducts(testCase.input));
        }
        end = Calendar.getInstance();

        double bTime = end.getTimeInMillis() - start.getTimeInMillis();

        System.out.println(String.format("ArraysOfProducts brutalForce\ttook %.2f milliseconds.", aTime));
        System.out.println(String.format("ArraysOfProducts withDivision\ttook %.2f milliseconds.", bTime));
        System.out.println(String.format("`withDivision` is '%.2f' times faster than `brutalForce`.", (aTime / bTime)));

        assertTrue(aTime > bTime);
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