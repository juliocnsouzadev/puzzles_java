package info.juliocnsouza.puzzles.functional;

import java.util.List;
import java.util.stream.Collectors;

public class SquareAndCollect {
    public static List<Integer> squareAndCollect(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }
}

