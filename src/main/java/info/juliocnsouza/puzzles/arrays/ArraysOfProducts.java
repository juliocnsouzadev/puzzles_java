package info.juliocnsouza.puzzles.arrays;

public class ArraysOfProducts {

    public int[] arrayOfProducts(int[] array) {
        if (array == null) {
            return new int[]{};
        }
        var result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            var product = 1;
            for (int j = 0; j < array.length; j++) {
                if (j == i) {
                    continue;
                }
                product = product * array[j];
            }
            result[i] = product;
        }

        return result;
    }
}
