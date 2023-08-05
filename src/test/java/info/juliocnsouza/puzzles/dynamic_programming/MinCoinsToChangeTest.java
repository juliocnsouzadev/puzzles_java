package info.juliocnsouza.puzzles.dynamic_programming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinCoinsToChangeTest {

    private MinCoinsToChange instance;

    @BeforeEach
    void setUp() {
        instance = new MinCoinsToChange();
    }

    @Test
    void testMinCoinsToChangeSuccess() {
        // fixture
        var coins = new int[]{1, 5, 10};
        var amount = 7;
        var expected = 3;

        // test
        var result = instance.change(amount, coins);

        // assertions
        assertEquals(expected, result);
    }

    @Test
    void testMinCoinsToChangeSuccess_oneCoin() {
        // fixture
        var coins = new int[]{1, 5, 10};
        var amount = 5;
        var expected = 1;

        // test
        var result = instance.change(amount, coins);

        // assertions
        assertEquals(expected, result);
    }

    @Test
    void testMinCoinsToChangeImpossible() {
        // fixture
        var coins = new int[]{10};
        var amount = 7;
        var expected = -1;

        // test
        var result = instance.change(amount, coins);

        // assertions
        assertEquals(expected, result);
    }

}