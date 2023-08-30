package info.juliocnsouza.puzzles.arrays;

import java.util.ArrayList;
import java.util.List;

public class LongestPeak {

    public static int longestPeak(int[] array) {
        if (isEdgeCase(array)) {
            return 0;
        }

        List<Integer> peakItems = new ArrayList<>();
        var longestPeak = 0;
        var increasing = false;

        var prev = array[0];
        peakItems.add(prev);

        for (int i = 1; i < array.length; i++) {
            var current = array[i];

            if (prev < current) {
                if (!increasing && !peakItems.isEmpty()) {
                    keepOnlyLastItem(peakItems);
                }
                increasing = true;
                peakItems.add(i);
            }

            if (prev > current && peakItems.size() > 1) {
                increasing = false;
                peakItems.add(i);
                longestPeak = getLongest(peakItems, longestPeak);
            }

            if (prev == current) {
                keepOnlyLastItem(peakItems);
            }

            prev = current;

        }

        return longestPeak;
    }

    private static boolean isEdgeCase(int[] array) {
        return array == null || array.length < 3;
    }

    private static void keepOnlyLastItem(List<Integer> items) {
        var last = items.get(items.size() - 1);
        items.clear();
        items.add(last);
    }

    private static int getLongest(List<Integer> items, int longest) {
        if (longest < items.size()) {
            longest = items.size();
        }
        return longest;
    }
}
