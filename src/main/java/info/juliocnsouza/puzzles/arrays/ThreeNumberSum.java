package info.juliocnsouza.puzzles.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    public List<Integer[]> exec(final int[] array, final int targetSum) {
        Arrays.sort(array);

        final List<Integer[]> results = new ArrayList<>();

        for (int i = 0; i < array.length - 2; i++) {
            final List<Integer> values = Arrays.asList(0, 0, 0);
            values.set(0, array[i]);
            for (int j = 0; j < array.length - 1; j++) {
                if (j == i) {
                    continue;
                }
                values.set(1, array[j]);
                values.set(2, array[j + 1]);

                final Integer sum = values.stream().reduce(0, (a, b) -> a + b);
                if (sum == targetSum) {
                    results.add((Integer[]) values.toArray());
                }
            }

        }

        return results;
    }
}
