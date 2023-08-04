package info.juliocnsouza.puzzles.functional;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterAndSortStringsTest {

    @Test
    public void testFilterAndSort() {
        // fixture
        final List<String> expected = Arrays.asList("apple", "banana");
        final List<String> input = Arrays.asList("a", "banana", "apple");

        // test
        final List<String> result = FilterAndSortStrings.filterAndSort(input);

        // assert
        assertEquals(expected, result);
    }

}