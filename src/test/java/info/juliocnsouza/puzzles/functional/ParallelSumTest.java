package info.juliocnsouza.puzzles.functional;

import org.junit.jupiter.api.Test;

import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.*;

class ParallelSumTest {

    @Test
    public void testSum() {
        //fixture
        var n = 1000000000;
        var input = Collections.nCopies(n, 1L);

        // test
        var start = new Date().getTime();
        var result = ParallelSum.sum(input);
        var pTime = Calendar.getInstance().toInstant().minus(start, ChronoUnit.MILLIS);

        start = new Date().getTime();
        var npResult = NonParallelSum.sum(input);
        var npTime = Calendar.getInstance().toInstant().minus(start, ChronoUnit.MILLIS);

        // assertions
        System.out.println("Parallel time:     " + pTime.toEpochMilli() + " ms");
        System.out.println("Non-parallel time: " + npTime.toEpochMilli() + " ms");

        assertEquals(n, result);
        assertEquals(n, npResult);
        assertTrue(pTime.toEpochMilli() < npTime.toEpochMilli());


    }

}