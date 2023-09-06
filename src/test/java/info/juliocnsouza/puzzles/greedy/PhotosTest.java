package info.juliocnsouza.puzzles.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PhotosTest {

    private Photos instance;

    @BeforeEach
    void setup() {
        instance = new Photos();
    }

    @Test
    void classPhotos() {
        List.of(
                        new TestCase(List.of(5, 8, 1, 3, 4), List.of(6, 9, 2, 4, 5), true),
                        new TestCase(List.of(6, 9, 2, 4, 5), List.of(5, 8, 1, 3, 4), true),
                        new TestCase(List.of(5, 6), List.of(5, 4), true),
                        new TestCase(List.of(3, 5, 6, 8, 2), List.of(2, 4, 7, 5, 1), true)
                )
                .forEach(
                        testCase -> {
                            //test
                            var result = instance.classPhotos(testCase.redShirtHeights, testCase.blueShirtHeights);

                            // assertions
                            Assertions.assertEquals(testCase.expected, result, testCase.toString());
                        }

                );
    }

    private static class TestCase {
        private List<Integer> redShirtHeights;
        private List<Integer> blueShirtHeights;
        private boolean expected;

        public TestCase(List<Integer> redShirtHeights, List<Integer> blueShirtHeights, boolean expected) {
            this.redShirtHeights = new ArrayList<>(redShirtHeights);
            this.blueShirtHeights = new ArrayList<>(blueShirtHeights);
            this.expected = expected;
        }

        @Override
        public String toString() {
            return "\n{" +
                    "\n\tredShirtHeights:" + redShirtHeights +
                    ",\n\tblueShirtHeights:" + blueShirtHeights +
                    "\n}";
        }
    }
}