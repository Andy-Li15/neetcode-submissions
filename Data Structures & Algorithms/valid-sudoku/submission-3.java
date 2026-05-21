class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] squares = new int[9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                // calculate values
                int val = board[r][c] - '1';
                if (val < 0) continue;
                int mask = 1 << val;
                int square = (r / 3) * 3 + (c / 3);

                // check for duplicates
                if ((rows[r] & mask) > 0 || 
                    (cols[c] & mask) > 0 || 
                    (squares[square] & mask) > 0) return false;
                
                // update seen values
                rows[r] |= mask;
                cols[c] |= mask;
                squares[square] |= mask;
            }
        }
        return true;
    }
}
