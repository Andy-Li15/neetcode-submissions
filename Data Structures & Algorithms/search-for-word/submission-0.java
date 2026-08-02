// assume board and word are not empty
class Solution {
    private record Coord(int i, int j) {}
    HashSet<Coord> used;
    boolean found;
    
    public boolean exist(char[][] board, String word) {
        used = new HashSet<>();
        found = false;

        // find first letter
        char first = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == first) {
                    Coord coord = new Coord(i, j);
                    used.add(coord);
                    dfs(board, word, i, j, 1);
                    used.remove(coord);
                }
            }
        }
        return found;
    }

    private void dfs(char[][] board, String word, int i, int j, int index) {
        if (index >= word.length()) found = true;
        if (found == true) return;
        char letter = word.charAt(index);

        // check 4 adjacent squares
        // square must be in bounds, contain next letter, and not be in used
        Coord coord = new Coord(i, j - 1);
        if (j - 1 >= 0 && board[i][j - 1] == letter && !used.contains(coord)) { // left
            used.add(coord);
            dfs(board, word, i, j - 1, index + 1);
            used.remove(coord);
        }
        coord = new Coord(i, j + 1);
        if (j + 1 < board[0].length && board[i][j + 1] == letter && !used.contains(coord)) { // right
            used.add(coord);
            dfs(board, word, i, j + 1, index + 1);
            used.remove(coord);
        }
        coord = new Coord(i - 1, j);
        if (i - 1 >= 0 && board[i - 1][j] == letter && !used.contains(coord)) { // top
            used.add(coord);
            dfs(board, word, i - 1, j, index + 1);
            used.remove(coord);
        }
        coord = new Coord(i + 1, j);
        if (i + 1 < board.length && board[i + 1][j] == letter && !used.contains(coord)) { // bootom
            used.add(coord);
            dfs(board, word, i + 1, j, index + 1);
            used.remove(coord);
        }
    }
}
