package info.juliocnsouza.puzzles.functional.math;

public class MathOperations {

    public Operation sum() {
        return new Sum();
    }

    public Operation subtract() {
        return new Subtract();
    }

    private static class Sum implements Operation {

        @Override
        public int apply(final int a, final int b) {
            return a + b;
        }

    }

    private static class Subtract implements Operation {

        @Override
        public int apply(final int a, final int b) {
            return a - b;
        }

    }

}
