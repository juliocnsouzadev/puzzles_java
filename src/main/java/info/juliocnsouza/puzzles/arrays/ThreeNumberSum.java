package info.juliocnsouza.puzzles.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    public List<Integer[]> exec(final int[] array, final int targetSum) {
        Arrays.sort(array);

        final List<Integer[]> results = new ArrayList<>();

        int position = 0;
        int left = position + 1;
        int right = array.length - 1;

        while (position < array.length - 2) {

            final int current = array[position];
            final int lValue = array[left];
            final int rValue = array[right];
            final int sum = current + lValue + rValue;

            if (sum == targetSum) {
                results.add(new Integer[]{current, lValue, rValue});
                right--;
                left++;
            } else if (sum > targetSum) {
                right--;
            } else {
                left++;
            }

            if (left >= right) {
                position++;
                left = position + 1;
                right = array.length - 1;
            }
        }
        return results;
    }
}
