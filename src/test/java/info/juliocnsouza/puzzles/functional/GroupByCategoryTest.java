package info.juliocnsouza.puzzles.functional;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GroupByCategoryTest {

    @Test
    public void testGroupByCategory() {
        // fixtures
        var p1 = new GroupByCategory.Product("Fruit", "Apple");
        var p2 = new GroupByCategory.Product("Fruit", "Grape");
        var p3 = new GroupByCategory.Product("Vegetable", "Carrot");
        var p4 = new GroupByCategory.Product("Vegetable", "Potato");
        var input = Arrays.asList(p1, p2, p3, p4);
        var expected = Map.of(
                "Fruit", Arrays.asList(p1,p2),
                "Vegetable", Arrays.asList(p3, p4)
        );

        //test
        var  result = GroupByCategory.groupByCategory(input);

        // assertions
        assertEquals(expected, result);
    }

}