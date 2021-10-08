package info.juliocnsouza.puzzles.arrays;

public class SortedSquaredArray {

    /**
     * Takes in a non-empty array of integers that are sorted
     * in ascending order and returns a new array of the same length with the squares
     * of the original integers also sorted in ascending order.
     * Time O(n), Space O(n)
     *
     * @param array
     * @return
     */
    public int[] sortAndSquare(final int[] array) {
        final int[] squaredSortedArray = new int[array.length];

        int left = 0;
        int right = array.length - 1;
        for (int i = array.length - 1; i >= 0; i--) {
            final int smaller = array[left];
            final int larger = array[right];

            if (Math.abs(larger) > Math.abs(smaller)) {
                squaredSortedArray[i] = larger * larger;
                right--;
            } else {
                squaredSortedArray[i] = smaller * smaller;
                left++;
            }

        }
        return squaredSortedArray;
    }
}
