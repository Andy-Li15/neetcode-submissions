class Solution {

    private static final int SIZE = 9;
    private static final int EMPTY = '.';

    public boolean isValidSudoku(char[][] board) {
        final int[] rows = new int[SIZE];
        final int[] cols = new int[SIZE];
        final int[] squares = new int[SIZE];

        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                // calculate values
                int val = board[r][c];
                if (val == EMPTY) continue;
                int mask = 1 << (val - '1');
                int square = (r / 3) * 3 + (c / 3);

                // check for duplicates
                if (((rows[r] & mask) | 
                    (cols[c] & mask) | 
                    (squares[square] & mask)) != 0) return false;
                
                // update seen values
                rows[r] |= mask;
                cols[c] |= mask;
                squares[square] |= mask;
            }
        }
        return true;
    }
}
