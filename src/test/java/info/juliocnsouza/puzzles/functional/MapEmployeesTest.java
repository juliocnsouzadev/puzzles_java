package info.juliocnsouza.puzzles.functional;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapEmployeesTest {

    @Test
    public void testMapEmployees() {
        // fixtures
        var e1 = new MapEmployees.Employee(1, "Alice", 50000);
        var e2 = new MapEmployees.Employee(1, "John", 50000);
        var e3 = new MapEmployees.Employee(2, "Mary", 50000);
        var expected =Map.of(
                1, List.of(e1, e2),
                2, List.of(e3)
        );
        var employees = Arrays.asList(e1, e2, e3);

        // test
        var result = MapEmployees.mapEmployees(employees);

        // assertions
        assertEquals(expected, result);
    }

}