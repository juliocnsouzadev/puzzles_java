package info.juliocnsouza.puzzles.arrays;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TournamentWinnerTest {

    @Test
    void get() {
        // fixtures
        final TournamentWinner tournamentWinner = new TournamentWinner();
        final List<Integer> results = List.of(0, 0, 0, 0);
        final List<List<String>> competitions = List.of(
                List.of("java", "python"),
                List.of("c#", "python"),
                List.of("c++", "python"),
                List.of("python", "javascript")
        );

        // expectations
        final String expected = "python";

        // test
        final String result = tournamentWinner.get(competitions, results);

        // assertions
        assertEquals(result, expected);
    }
}