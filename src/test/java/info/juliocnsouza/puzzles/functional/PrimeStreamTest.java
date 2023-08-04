package info.juliocnsouza.puzzles.functional;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class PrimeStreamTest {

    @Test
    public void testPrimes() {
        // fixture
        var expected = Arrays.asList(2, 3, 5, 7);
        var n = 4;

        // test
        var result = PrimeStream.primes(n).collect(Collectors.toList());

        // assertions
        assertEquals(expected, result);
    }

}