package info.juliocnsouza.puzzles.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MoveElement {
    public static List<Integer> toTheEnd(List<Integer> array, int toMove) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int value : array) {
            if (value != toMove) {
                left.add(value);
            } else {
                right.add(value);
            }
        }

        left.addAll(right);
        return left;
    }

    public static List<Integer> toTheEndStream(List<Integer> array, int toMove) {
        var end = array.stream().filter(n -> n == toMove).collect(Collectors.toList());
        var result = array.stream().filter(n -> n != toMove)
                .collect(Collectors.toList());
        result.addAll(end);

        return result;
    }
}
