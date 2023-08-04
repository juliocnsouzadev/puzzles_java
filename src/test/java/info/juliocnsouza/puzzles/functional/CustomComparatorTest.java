package info.juliocnsouza.puzzles.functional;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomComparatorTest {
    @Test
    public void testSortEmployees() {
        // fixture
        var e1 = new CustomComparator.Employee("Alice", 30);
        var e2 = new CustomComparator.Employee("Bob", 25);
        var e3 = new CustomComparator.Employee("Charlie", 30);
        var input = Arrays.asList(e1, e2, e3);
        var expected = Arrays.asList(e2, e1, e3);

        // test
        var result = CustomComparator.sortEmployees(input);

        // assertion
        assertEquals(expected, result);
    }
}