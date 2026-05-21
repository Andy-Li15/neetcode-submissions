class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] squares = new int[9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int val = board[r][c] - '1';
                if (val < 0) continue;
                int mask = 1 << val;
                if ((rows[r] & mask) > 0) return false; // duplicate in row
                rows[r] |= mask;
                if ((cols[c] & mask) > 0) return false; // duplicate in col
                cols[c] |= mask;
                int square = (r / 3) * 3 + (c / 3);
                if ((squares[square] & mask) > 0) return false;
                squares[square] |= mask;
            }
        }
        return true;
    }
}
