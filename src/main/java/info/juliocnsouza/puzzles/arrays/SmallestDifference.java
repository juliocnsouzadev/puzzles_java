package info.juliocnsouza.puzzles.arrays;

import java.util.Arrays;

// time: O(nLog(n) + mLog(m))
// space: O(1)
public class SmallestDifference {

    public int[] execute(int[] arg1, int[] arg2){
        Arrays.sort(arg1);
        Arrays.sort(arg2);

        if(arg1[0] < arg2[0]){
            return getSmallestDiffPair(arg1, arg2, false);
        }else{
            return getSmallestDiffPair(arg2, arg1, true);
        }
    }

    private int[] getSmallestDiffPair(int[] firstArr, int[] secondArr, boolean reverse){
        int firstIdx = 0;
        int secondIndex = 0;
        int difference = Integer.MAX_VALUE;
        int pair[] = new int[2];
        while(firstIdx < firstArr.length && secondIndex < secondArr.length){

            final int first = firstArr[firstIdx];
            final int second = secondArr[secondIndex];
            int currentDiff = Math.abs(first - second);

            if (currentDiff < difference){
                difference = currentDiff;
                pair[0] = reverse? second : first;
                pair[1] = reverse? first : second;
                if(difference == 0){
                    break;
                }
            }
            if (first > second){
                secondIndex++;
            }else{
                firstIdx++;
            }
        }
        return pair;
    }
}
