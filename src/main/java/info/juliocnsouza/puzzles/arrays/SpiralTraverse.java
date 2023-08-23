package info.juliocnsouza.puzzles.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

    public static List<Integer> spiralTraverse(int[][] arrays) {
        List<Integer> result = new ArrayList<>();

        final State state = new State(
                0,
                arrays[0].length - 1,
                0,
                arrays.length - 1,
                State.Direction.LEFT_TO_RIGHT
        );

        while (state.canChangeState()) {
            switch (state.direction) {
                case LEFT_TO_RIGHT:
                    for (int i = state.left; i <= state.right; i++) {
                        result.add(arrays[state.top][i]);
                    }
                    state.nextState(State.Direction.TOP_TO_BOTTOM);
                    state.increaseTop();
                    break;
                case TOP_TO_BOTTOM:
                    for (int i = state.top; i <= state.bottom; i++) {
                        result.add(arrays[i][state.right]);
                    }
                    state.nextState(State.Direction.RIGHT_TO_LEFT);
                    state.decreaseRight();
                    break;
                case RIGHT_TO_LEFT:
                    for (int i = state.right; i >= state.left; i--) {
                        result.add(arrays[state.bottom][i]);
                    }
                    state.nextState(State.Direction.BOTTOM_TO_TOP);
                    state.decreaseBottom();
                    break;
                case BOTTOM_TO_TOP:
                    for (int i = state.bottom; i >= state.top; i--) {
                        result.add(arrays[i][state.left]);
                    }
                    state.nextState(State.Direction.LEFT_TO_RIGHT);
                    state.increaseLeft();
                    break;
            }

        }

        return result;
    }

    private static class State {
        int left, right, top, bottom;
        Direction direction;

        public State(int left, int right, int top, int bottom, Direction direction) {
            this.left = left;
            this.right = right;
            this.top = top;
            this.bottom = bottom;
            this.direction = direction;
        }

        public void nextState(Direction direction) {
            this.direction = direction;
        }

        public boolean canChangeState() {
            return left <= right && top <= bottom;
        }

        public void increaseTop() {
            this.top++;
        }

        public void decreaseRight() {
            this.right--;
        }

        public void decreaseBottom() {
            this.bottom--;
        }

        public void increaseLeft() {
            this.left++;
        }

        enum Direction {
            LEFT_TO_RIGHT,
            TOP_TO_BOTTOM,
            RIGHT_TO_LEFT,
            BOTTOM_TO_TOP
        }
    }
}
