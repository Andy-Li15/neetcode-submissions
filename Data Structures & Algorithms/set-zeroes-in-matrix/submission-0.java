// use matrix[0][j] and matrix[i][0] to mark rows and cols
// matrix[0][0]: setZeroRow, setZeroCol
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean set0Row = false;
        boolean set0Col = false;

        // mark rows and cols
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (i == 0) set0Row = true;
                    if (j == 0) set0Col = true;
                }
            }
        }

        // set rows and cols
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (set0Col) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (set0Row) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
