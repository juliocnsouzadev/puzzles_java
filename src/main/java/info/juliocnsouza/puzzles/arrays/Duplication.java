package info.juliocnsouza.puzzles.arrays;

import java.util.HashMap;

public class Duplication {

    public int firstDuplicateValue(int[] array) {
        var itemsCounter = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            var currentItem = array[i];
            var found = itemsCounter.get(currentItem);
            if (found != null) {
                return currentItem;
            }
            itemsCounter.put(currentItem, 1);
        }
        return -1;
    }

}
