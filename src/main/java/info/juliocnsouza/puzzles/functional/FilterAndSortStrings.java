package info.juliocnsouza.puzzles.functional;

import java.util.List;
import java.util.stream.Collectors;

public class FilterAndSortStrings {
    public static List<String> filterAndSort(List<String> strings) {
        return strings.stream()
                .filter(s -> s.length() >= 5)
                .sorted()
                .collect(Collectors.toList());
    }
}

