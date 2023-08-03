package info.juliocnsouza.puzzles.dynamic_programming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfWaysToMakeChangeTest {

    private NumberOfWaysToMakeChange instance;

    @BeforeEach
    void setUp() {
        instance = new NumberOfWaysToMakeChange();
    }

    @Test
    void shouldVerifyNumberOfWaysToMakeChangeWithSuccess() throws Exception {
        //fixture
        var n = 6;
        var denominations = new int[]{1, 5};
        var expected = 2;
        //test
        var result = instance.numberOfWaysToMakeChange(n, denominations);

        //assertions
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnOneNumberOfWaysToMakeChange_valueIsZero() throws Exception {
        //fixture
        var n = 0;
        var denominations = new int[]{1, 5};
        var expected = 1;
        //test
        var result = instance.numberOfWaysToMakeChange(n, denominations);

        //assertions
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnOneNumberOfWaysToMakeChange_valueIsNegative() throws Exception {
        //fixture
        var n = -1;
        var denominations = new int[]{1, 5};
        var expected = 1;
        //test
        var result = instance.numberOfWaysToMakeChange(n, denominations);

        //assertions
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnOneNumberOfWaysToMakeChange_denominationNull() throws Exception {
        //fixture
        var n = 2;
        var expected = 1;
        //test
        var result = instance.numberOfWaysToMakeChange(n, null);

        //assertions
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnOneNumberOfWaysToMakeChange_denominationEmpty() throws Exception {
        //fixture
        var n = 2;
        var denominations = new int[]{};
        var expected = 1;
        //test
        var result = instance.numberOfWaysToMakeChange(n, denominations);

        //assertions
        assertEquals(expected, result);
    }

}