package info.juliocnsouza.puzzles.dynamic_programming;

public class NumberOfWaysToMakeChange {
    public int numberOfWaysToMakeChange(int wantedAmount, int[] coins) {
        if (wantedAmount <= 0 || coins == null || coins.length == 0) {
            return 1;
        }
        var ways = new int[wantedAmount + 1];
        ways[0] = 1; //for zero amount there is one way to make change
        for (int coin : coins) {
            for (int amount = 1; amount <= wantedAmount; amount++) {
                if (coin <= amount) {
                    var previousWay = ways[amount - coin];
                    var currentWay = ways[amount];
                    ways[amount] = currentWay + previousWay;
                }
            }
        }
        return ways[wantedAmount];
    }
}
