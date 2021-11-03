package info.juliocnsouza.puzzles.arrays;

import java.util.HashSet;
import java.util.Set;

public class TwoNumberSum {

    public static int[] exec(final int[] array, final int targetSum) {
        final Set<Integer> numbers = new HashSet<>();
        for (final int x : array) {
            final int y = targetSum - x;
            if (numbers.contains(y)) {
                return new int[]{x, y};
            }
            numbers.add(x);
        }
        return new int[0];
    }
}
