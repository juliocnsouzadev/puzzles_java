package info.juliocnsouza.puzzles.functional;

import java.util.stream.Stream;

public class PrimeStream {
    public static Stream<Integer> primes(int n) {
        return Stream.iterate(2, i -> i + 1)
                .filter(PrimeStream::isPrime)
                .limit(n);
    }

    private static boolean isPrime(int integer) {
        return Stream.iterate(2, i -> i + 1)
                .limit(integer - 2)
                .noneMatch(i -> integer % i == 0);
    }
}

