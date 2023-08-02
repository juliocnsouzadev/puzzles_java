package info.juliocnsouza.puzzles.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TransposeMatrixTest {

    private TransposeMatrix instance;

    @BeforeEach
    void init(){
        instance = new TransposeMatrix();
    }
    @Test
    void shouldTransposeMatrixWithSuccess() throws Exception {
        // fixtures
        var input = new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        };

        var expected = new int[][]{
                {1, 4},
                {2, 5},
                {3, 6}
        };

        var expectedRows = expected.length;
        var expectedCols = expected[0].length;

        // test
        var result = instance.transpose(input);

        // assert
        assertEquals(expectedRows, result.length);
        assertEquals(expectedCols, result[0].length);
        assertArrayEquals(expected, result);
    }

    @Test
    void shouldReturnNullWhenInputIsNull() throws Exception {
        var result = instance.transpose(null);
        assertNull(result);
    }

    @Test
    void shouldEmptyNullWhenInputIsEmpty() throws Exception {
        var input = new int[][]{};

        var expected = new int[][]{};

        // test
        var result = instance.transpose(input);

        // assert
        assertArrayEquals(expected, result);
    }
  
}