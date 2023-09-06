package info.juliocnsouza.puzzles.greedy;

import java.util.Collections;
import java.util.List;

public class Photos {

    public boolean classPhotos(List<Integer> redShirtStudentsHeights, List<Integer> blueShirtStudentsHeights) {
        Collections.sort(redShirtStudentsHeights);
        Collections.sort(blueShirtStudentsHeights);

        var i = 0;
        var thRedShirtStudent = redShirtStudentsHeights.get(i);
        var thBlueShirtStudent = blueShirtStudentsHeights.get(i);

        final boolean thStudentsSameHeight = thBlueShirtStudent == thRedShirtStudent;
        if (thStudentsSameHeight) {
            return false;
        }

        final boolean redRowShouldBeInFront = thRedShirtStudent < thBlueShirtStudent;
        final boolean blueRowShouldBeInFront = !redRowShouldBeInFront;

        for (i = 1; i < redShirtStudentsHeights.size(); i++) {
            thRedShirtStudent = redShirtStudentsHeights.get(i);
            thBlueShirtStudent = blueShirtStudentsHeights.get(i);

            final boolean thBlueShirStudentIsInFront = thRedShirtStudent >= thBlueShirtStudent;
            if (redRowShouldBeInFront && thBlueShirStudentIsInFront) {
                return false;
            }

            final boolean thRedShirtStudentIsInFront = thBlueShirtStudent >= thRedShirtStudent;
            if (blueRowShouldBeInFront && thRedShirtStudentIsInFront) {
                return false;
            }
        }
        return true;
    }

}
