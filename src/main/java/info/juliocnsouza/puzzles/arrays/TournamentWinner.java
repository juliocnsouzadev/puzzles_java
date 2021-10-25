package info.juliocnsouza.puzzles.arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TournamentWinner {
    public String get(
            final List<List<String>> competitions, final List<Integer> results) {
        final Map<String, Integer> points = new HashMap<>();
        String leader = null;
        int higherScore = 0;
        for (int i = 0; i < competitions.size(); i++) {
            final String winner = results.get(i) == 1 ?
                    competitions.get(i).get(0) : competitions.get(i).get(1);
            Integer actualPoints = points.get(winner);
            actualPoints = actualPoints == null ? 3 : actualPoints + 3;
            points.put(winner, actualPoints);
            if (actualPoints > higherScore) {
                higherScore = actualPoints;
                leader = winner;
            }
        }
        return leader;
    }
}
