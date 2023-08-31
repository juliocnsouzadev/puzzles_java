package info.juliocnsouza.puzzles.arrays;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LongestPeakTest {

    final List<TestCase> testCases = List.of(
            TestCase.getInstance(List.of(1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3), 6),
            TestCase.getInstance(List.of(), 0),
            TestCase.getInstance(List.of(1, 3, 2), 3),
            TestCase.getInstance(List.of(5, 4, 3, 2, 1, 2, 10, 12), 0)
    );

    @Test
    void testLongestPeak_happyPath() {
        testCases
                .forEach(
                        testCase -> {
                            // test
                            var output = LongestPeak.longestPeak(testCase.input);

                            // assertions
                            assertEquals(testCase.expected, output);
                        }
                );
    }

    @Test
    void testLongestPeakWhile_happyPath() {
        testCases
                .forEach(
                        testCase -> {
                            // test
                            var output = LongestPeak.longestPeakWhile(testCase.input);

                            // assertions
                            assertEquals(testCase.expected, output);
                        }
                );
    }

    @Test
    void testLongestPerformanceComparison() {

        var start = Calendar.getInstance();
        final int loops = 10000000;
        for (int i = 0; i < loops; i++) {
            testCases.forEach(testCase -> LongestPeak.longestPeak(testCase.input));
        }
        var end = Calendar.getInstance();

        var aTime = end.getTimeInMillis() - start.getTimeInMillis();

        start = Calendar.getInstance();
        for (int i = 0; i < loops; i++) {
            testCases.forEach(testCase -> LongestPeak.longestPeakWhile(testCase.input));
        }
        end = Calendar.getInstance();

        var bTime = end.getTimeInMillis() - start.getTimeInMillis();

        System.out.println(String.format("LongestPeak.longestPeak\t\t\ttook %d milliseconds.", aTime));
        System.out.println(String.format("LongestPeak.longestPeakWhile\ttook %d milliseconds.", bTime));
        System.out.println(String.format("`longestPeak` is '%d' times faster than `longestPeakWhile`.", (aTime / bTime)));

        assertTrue(aTime > bTime);

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