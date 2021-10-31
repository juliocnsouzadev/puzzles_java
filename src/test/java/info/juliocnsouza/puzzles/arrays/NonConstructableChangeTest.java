package info.juliocnsouza.puzzles.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NonConstructableChangeTest {

    @Test
    void exec() {
        // fixtures
        final int[] coins = new int[]{5, 7, 1, 1, 2, 3, 22};

        // expectations
        int expected = 20;

        // test
        final NonConstructableChange nonConstructableChange = new NonConstructableChange();
        int result = nonConstructableChange.exec(coins);
        
        assertEquals(expected, result);
    }
}