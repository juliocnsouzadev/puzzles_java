package info.juliocnsouza.puzzles.arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class ValidateSubSequenceTest {

    @Test
    @DisplayName("Given two non-empty arrays of integers, write a function that determines\n" +
            "whether the second array is a subsequence of the first one.")
    void isValidSubsequence() {
        //Fixtures
        final Random random = new Random();
        final List<Integer> list = new ArrayList<>();
        final List<Integer> validSequence = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            final int number = random.nextInt(1000);
            list.add(number);
            if (random.nextBoolean()) {
                validSequence.add(number);
            }
        }
        final List<Integer> invalidSequence = validSequence.stream().collect(Collectors.toList());
        final Integer first = invalidSequence.get(0);
        final int lastIdx = invalidSequence.size() - 1;
        final Integer last = invalidSequence.get(lastIdx);
        invalidSequence.set(0, last);
        invalidSequence.set(lastIdx, first);

        // tests
        final ValidateSubSequence validateSubSequence = new ValidateSubSequence();
        final boolean validResult = validateSubSequence.isValidSubsequence(list, validSequence);
        final boolean invalidResult = validateSubSequence.isValidSubsequence(list, invalidSequence);

        assertThat(validResult).isEqualTo(Boolean.TRUE);
        assertThat(invalidResult).isEqualTo(Boolean.FALSE);
    }
}