package info.juliocnsouza.puzzles.arrays;

public class Monotonic {
    public static boolean isMonotonic(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return true;
        }

        int prev = array[0];
        int current = array[1];
        int i = 2;
        while (current == prev && i < array.length) {
            prev = current;
            current = array[i];
            i++;
        }

        final boolean increasing = prev < current;
        for (; i < array.length; i++) {
            prev = current;
            current = array[i];

            if (current == prev) {
                continue;
            }

            boolean stillSameDirection = increasing == (prev < current);
            if (!stillSameDirection) {
                return false;
            }
        }
        return true;
    }
}
