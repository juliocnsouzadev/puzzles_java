package info.juliocnsouza.puzzles.arrays;

public class ArraysOfProductsUsesDivision {

    public int[] arrayOfProducts(int[] array) {
        if (array == null) { // edge case
            return new int[]{};
        }

        var track = ProductTrack.getInstance();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                track.incrementZeros();
                if (track.allProductsWillBeZero()) {
                    break; //don't need to loop anymore since all possible products will be 0
                }
                track.replaceMinZeroPosition(i);
                track.replaceMaxZeroPosition(i);
                continue; // go to next since without need to update product
            }

            track.multiplyProductByNonZero(array[i]);
        }

        var result = new int[array.length];
        for (int i = 0; i < array.length; i++) {

            if (track.allProductsWillBeZero()) {
                // just fill everything with zeros
                while (i < array.length) {
                    result[i] = 0;
                    i++;
                }
                break;
            }

            if (track.hasZerosAtTheSides(i)) {
                result[i] = 0; // this position product will be zero since has zero as element
                continue;
            }

            if (array[i] == 0) {
                result[i] = track.product; // will be the full product (zeroless) itself
                continue;
            }
            result[i] = track.product / array[i]; // will be the product of all non zero elements excluding the current one

        }

        return result;
    }

    private static class ProductTrack {
        private int product;
        private int zeros;
        private Integer minZeroPosition;
        private Integer maxZeroPosition;

        private ProductTrack() {
            this.product = 1;
            this.zeros = 0;
        }

        static ProductTrack getInstance() {
            return new ProductTrack();
        }

        void incrementZeros() {
            this.zeros++;
        }

        boolean allProductsWillBeZero() {
            return this.zeros > 1;
        }

        void replaceMinZeroPosition(int index) {
            if (this.minZeroPosition == null || index < this.minZeroPosition) {
                this.minZeroPosition = index;
            }
        }

        void replaceMaxZeroPosition(int index) {
            if (this.maxZeroPosition == null || index > this.maxZeroPosition) {
                this.maxZeroPosition = index;
            }
        }

        void multiplyProductByNonZero(int value) {
            if (value == 0) {
                return;
            }
            this.product = product * value;
        }

        boolean hasZerosAtTheSides(int index) {
            return (this.minZeroPosition != null && this.minZeroPosition < index)
                    || (this.maxZeroPosition != null && this.maxZeroPosition > index);
        }
    }
}
