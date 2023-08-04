package info.juliocnsouza.puzzles.functional;

import java.util.List;

public class ParallelSum {

    public static long sum(List<Long> numbers) {
        return numbers.parallelStream().reduce(0L, Long::sum);
    }

}

