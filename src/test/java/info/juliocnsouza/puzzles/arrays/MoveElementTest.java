package info.juliocnsouza.puzzles.arrays;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MoveElementTest {

    @Test
    void moveElementToEnd() {
        // fixtures
        var data = List.of(2, 1, 2, 2, 2, 3, 4, 2);
        var toMove = 2;
        var expected = List.of(1, 3, 4, 2, 2, 2, 2, 2);

        // test
        var resultA = MoveElement.toTheEnd(data, toMove);
        var resultB = MoveElement.toTheEndStream(data, toMove);

        // assertions
        assertEquals(expected, resultA);
        assertEquals(expected, resultB);
    }

    @Test
    void moveElementCompare() {
        // fixtures
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            data.add(new Random().nextInt());
        }
        var toMove = data.get(10000);

        // test
        var start = Calendar.getInstance();
        MoveElement.toTheEnd(data, toMove);
        var timeStandardImpl = start.getTimeInMillis() - Calendar.getInstance().getTimeInMillis();

        start = Calendar.getInstance();
        MoveElement.toTheEndStream(data, toMove);
        var timeStreamImpl = start.getTimeInMillis() - Calendar.getInstance().getTimeInMillis();

        // assertions
        assertTrue(timeStandardImpl < timeStreamImpl);
    }
}