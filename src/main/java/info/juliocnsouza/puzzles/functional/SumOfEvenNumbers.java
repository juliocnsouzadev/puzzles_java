package info.juliocnsouza.puzzles.functional;

import java.util.List;

public class SumOfEvenNumbers {
    public static int sumOfEven(List<Integer> numbers) {
        return numbers.stream()
                .filter(SumOfEvenNumbers::isEven)
                .reduce(SumOfEvenNumbers::sum)
                .orElse(0);
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }

    private static int sum(int a, int b) {
        return a + b;
    }

    public static Integer sumOfEvenLambda(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce((a, b) -> a + b)
                .orElse(0);
    }
}
