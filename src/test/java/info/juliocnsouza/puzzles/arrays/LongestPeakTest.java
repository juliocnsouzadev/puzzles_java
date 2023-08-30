package info.juliocnsouza.puzzles.arrays;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestPeakTest {

    @Test
    void testLongestPeak_happyPath() {

        List.of(
                        TestCase.getInstance(List.of(1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3), 6),
                        TestCase.getInstance(List.of(), 0),
                        TestCase.getInstance(List.of(1, 3, 2), 3),
                        TestCase.getInstance(List.of(5, 4, 3, 2, 1, 2, 10, 12), 0)
                )
                .forEach(
                        testCase -> {
                            // test
                            var output = LongestPeak.longestPeak(testCase.input);

                            // assertions
                            assertEquals(testCase.expected, output);
                        }
                );


    }

    private static class TestCase {
        int[] input;
        int expected;

        private TestCase(int[] input, int expected) {
            this.input = input;
            this.expected = expected;
        }

        static TestCase getInstance(List<Integer> input, int expected) {
            return new TestCase(input.stream().mapToInt(a -> a).toArray(), expected);
        }

    }

}