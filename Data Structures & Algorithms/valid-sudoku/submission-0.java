class Solution {
    BitSet bitset = new BitSet(9);

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!checkRow(board, i)) return false;
            if (!checkCol(board, i)) return false;
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!checkSquare(board, i, j)) return false;
            }
        }
        return true;
    }

    private boolean checkRow(char[][] board, int row) {
        bitset.clear();
        for (int i = 0; i < 9; i++) {
            int val = board[row][i] - '0';
            System.out.println(val);
            if (val < 1) continue;
            if (bitset.get(val)) return false; // duplicate
            bitset.set(val);
        }
        return true;
    }

    private boolean checkCol(char[][] board, int col) {
        bitset.clear();
        for (int i = 0; i < 9; i++) {
            int val = board[i][col] - '0';
            if (val < 1) continue;
            if (bitset.get(val)) return false; // duplicate
            bitset.set(val);
        }
        return true;
    }

    private boolean checkSquare(char[][] board, int row, int col) {
        bitset.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int val = board[i + row][j + col] - '0';
                if (val < 1) continue;
                if (bitset.get(val)) return false;
                bitset.set(val);
            }
        }
        return true;
    }
}
