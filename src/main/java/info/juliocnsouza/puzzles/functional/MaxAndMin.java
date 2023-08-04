package info.juliocnsouza.puzzles.functional;

import java.util.List;

public class MaxAndMin {
    public static int findMax(List<Integer> numbers) {
        return numbers.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
    }

    public static int findMin(List<Integer> numbers) {
         return numbers.stream().reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b);
    }
}

