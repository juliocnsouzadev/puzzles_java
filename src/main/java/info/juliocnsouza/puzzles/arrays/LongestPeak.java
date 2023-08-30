package info.juliocnsouza.puzzles.arrays;

import java.util.ArrayList;
import java.util.List;

public class LongestPeak {

    public static int longestPeakWhile(int[] array) {
        if (isEdgeCase(array)) {
            return 0;
        }
        var longestPeak = 0;

        for (int i = 1; i < array.length - 1; i++) {
            var prev = array[i - 1];
            var current = array[i];
            var next = array[i + 1];
            var isPeak = prev < current && current > next;
            if (!isPeak) {
                continue;
            }

            final int left = leftOfPeak(array, i);
            final int right = rightOfPeak(array, i);
            var currentPeak = right - left - 1;
            longestPeak = longestPeak < currentPeak ? currentPeak : longestPeak;
            i = right;
        }

        return longestPeak;
    }

    private static boolean isEdgeCase(int[] array) {
        return array == null || array.length < 3;
    }

    private static int leftOfPeak(int[] array, int i) {
        var leftIdx = i - 2;
        if (leftIdx >= 0) {
            return -1;
        }

        while (leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]) {
            leftIdx--;
        }
        return leftIdx;
    }

    private static int rightOfPeak(int[] array, int i) {
        var rightIdx = i + 2;
        if (rightIdx > array.length) {
            return -1;
        }

        while (rightIdx > array.length && array[rightIdx] < array[rightIdx - 1]) {
            rightIdx++;
        }
        return rightIdx;
    }

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
