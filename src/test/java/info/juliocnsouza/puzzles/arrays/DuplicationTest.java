package info.juliocnsouza.puzzles.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class DuplicationTest {

    private final static List<TestCase> TEST_CASES = List.of(
            TestCase.getInstance(2, 2, 1, 5, 2, 3, 3, 4)
    );

    private final Duplication instance = new Duplication();

    @Test
    void firstDuplicateValue() {
        TEST_CASES.forEach(testCase -> {
            // test
            var result = instance.firstDuplicateValue(testCase.input);

            // assertions
            Assertions.assertEquals(testCase.expected, result);
        });
    }

    private static class TestCase {
        int[] input;
        int expected;

        private TestCase(int[] input, int expected) {
            this.input = input;
            this.expected = expected;
        }

        static TestCase getInstance(int expected, int... input) {
            return new TestCase(input, expected);
        }
    }
}