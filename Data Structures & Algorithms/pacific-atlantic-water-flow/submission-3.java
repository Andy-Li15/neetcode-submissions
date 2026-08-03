class Solution {
    private int n;
    private int m;
    private int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        for (int i = 0; i < n; i++) { // left and right side
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, m - 1);
        }
        for (int j = 0; j < m; j++) { // top and bottom side
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, n - 1, j);
        }

        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    answer.add(List.of(i, j));
                }
            }
        }
        return answer;
    }

    private void dfs(int[][] heights, boolean[][] ocean, int i, int j) {
        ocean[i][j] = true;

        // if an adjacent cell has a higher height, dfs the adjacent cell
        for (int[] dir : dirs) {
            int i2 = i + dir[0];
            int j2 = j + dir[1];
            if (i2 >= 0 && i2 < n && j2 >= 0 && j2 < m && !ocean[i2][j2] && heights[i2][j2] >= heights[i][j]) {
                dfs(heights, ocean, i2, j2);
            }
        }
    }
}
