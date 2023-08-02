package info.juliocnsouza.puzzles.arrays;
public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        var rows = matrix.length;
        if (rows == 0) {
            return matrix;
        }

        var cols = matrix[0].length;
        var result = new int[cols][rows];

        for (var i = 0; i < rows; i++){
            var row = matrix[i];
            for (var j = 0; j < cols; j++){
                var value = row[j];
                result[j][i] = value;
            }
        }

        return result;
    }
}
