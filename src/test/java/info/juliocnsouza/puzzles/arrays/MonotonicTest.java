package info.juliocnsouza.puzzles.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MonotonicTest {

    @Test
    void test_isMonotonic() {

        // fixture
        var cases = List.of(
                new TestCase(new int[]{-1, -2, -10, -1100, -1101, -9001}, true),
                new TestCase(new int[]{1, 1, 2, 3, 4, 5, 5, 5, 6, 7, 8, 8, 9, 10, 11}, true),
                new TestCase(new int[]{1, 1, 2, 3, 4, 5, 5, 5, -4, 7, 8, 8, 9, 10, 11}, false),
                new TestCase(new int[]{1}, true),
                new TestCase(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, true),
                new TestCase(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 10}, false)
        );

        // test
        var results = cases.stream().map(testCase -> {
            testCase.output = Monotonic.isMonotonic(testCase.input);
            return testCase;
        }).collect(Collectors.toList());

        // assertions
        results.stream().forEach(result -> {
            assertEquals(result.expected, result.output, result.result());
        });
    }

    private static class TestCase {
        int[] input;
        boolean expected;
        boolean output;

        public TestCase(int[] input, boolean expected) {
            this.input = input;
            this.expected = expected;
        }

        public String result() {
            final String inputAsString = Arrays.toString(this.input);
            if (expected != output) {
                return String.format("Expected %b but got %b for %s", this.expected, this.output, inputAsString);
            }
            return String.format("Passed for %s", inputAsString);
        }
    }

}