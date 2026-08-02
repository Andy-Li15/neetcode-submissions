/*
let an n x n board be represented as an int[n][n]
    i is vertical top to bottom, from 0 to n - 1
    j is horizontal left to right, from 0 to n - 1

if board[i][j] is 0, then a queen can be placed there
    try placing a queen and updating queenPos[i] = j
    recurse
    then remove the queen and continue

checks squares left to right, top to bottom

Optimization
    stop checking rest of row when a queen is placed there
*/
class Solution {
    // for solution
    private List<List<String>> result;
    private List<String> solution;
    private int n;

    // for queen data
    private int[][] board; // tracks if a square is valid
    private int[] queenPos; // position of queen at each row
    private int queens; // number of queens
    private StringBuilder sb; // make String representation of row


    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        solution = new ArrayList<>();
        this.n = n;
        
        board = new int[n][n];
        queenPos = new int[n];
        queens = 0;
        sb = new StringBuilder(n);
        
        getSolutions(0, 0);
        return result;
    }

    private void getSolutions(int i, int j) {
        // check if board found
        if (queens == n) {
            solution.clear();
            for (int pos : queenPos) {
                solution.add(getRow(pos));
            }
            result.add(new ArrayList<>(solution));
            return;
        }
        if (i >= n) {
            return;
        }

        // try adding queen at i, j
        if (board[i][j] == 0) {
            placeQueen(i, j, true);
            getSolutions(i + 1, 0);
            placeQueen(i, j, false);
        }
        // skip square
        int nextI = i + ((j + 1) / n);
        int nextJ = (j + 1) % n;
        getSolutions(nextI, nextJ);
    }

    // if place == true, simulate placing a queen at board[i0][j0]
    // if place == false, simulate removing a queen at board[i0][j0]
    private void placeQueen(int i0, int j0, boolean place) {
        int change;
        if (place) {
            change = 1;
            queenPos[i0] = j0;
        } else {
            change = -1;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == i0 || j == j0 || isDiagonal(i, j, i0, j0)) {
                    board[i][j] += change;
                }
            }
        }
        queens += change;
    }

    // returns true if (i, j) is diagonal to (i0, j0), false otherwise
    private boolean isDiagonal(int i, int j, int i0, int j0) {
        return Math.abs(i - i0) == Math.abs(j - j0);
    }

    // get String representation of row with queen at board[_][queenPos]
    private String getRow(int queenPos) {
        sb.setLength(0);
        for (int i = 0; i < queenPos; i++) {
            sb.append('.');
        }
        sb.append('Q');
        for (int i = queenPos + 1; i < n; i++) {
            sb.append('.');
        }
        return sb.toString();
    }
}






