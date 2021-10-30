package info.juliocnsouza.puzzles.arrays;

import java.util.Arrays;

public class NonConstructableChange {
    // [5, 7, 1, 1, 2, 3, 22] = 20
    // [1, 1, 2, 3, 5, 7, 22] = 20
    public int exec(final int[] coins) {
        if (coins == null || coins.length == 0) {
            return 1;
        }
        Arrays.sort(coins);
        int sum = 0;
        for (int i = 0; i < coins.length; i++) {
            final int currentCoin = coins[i];
            if (sum + 1 < currentCoin) {
                return sum + 1;
            }
            sum += currentCoin;
        }
        return -1;
    }


}
