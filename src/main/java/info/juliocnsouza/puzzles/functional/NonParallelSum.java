package info.juliocnsouza.puzzles.functional;

import java.util.List;

public class NonParallelSum {

    public static long sum(List<Long> numbers) {
        return numbers.stream().reduce(0L, Long::sum);
    }

}

