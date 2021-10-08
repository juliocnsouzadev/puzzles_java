package info.juliocnsouza.puzzles.arrays;

import java.util.List;

public class ValidateSubSequence {

    /**
     * Given two non-empty arrays of integers, write a function that determines
     * whether the second array is a subsequence of the first one.
     *
     * @param array
     * @param sequence
     * @return
     */
    public boolean isValidSubsequence(final List<Integer> array, final List<Integer> sequence) {
        int seqPointer = 0;
        for (int i = 0; i < array.size(); i++) {
            final int actual = array.get(i);
            if (actual == sequence.get(seqPointer)) {
                seqPointer++;
            }
            if (seqPointer >= sequence.size()) {
                break;
            }
        }
        return seqPointer == sequence.size();
    }

}
