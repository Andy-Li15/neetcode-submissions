/*
Dynamic programming
dp[i][j + 1] is the result at index i where j was the previous index
*/
class Solution {
    private int[][] dp;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(0, -1, nums);
    }

    private int dfs(int i, int j, int[] nums) {
        if (i == nums.length) {
            return 0;
        }
        if (dp[i][j + 1] != -1) {
            return dp[i][j + 1];
        }

        // exclude
        int exclude = dfs(i + 1, j, nums);
        
        // include;
        int include = exclude;
        if (j == -1 || nums[j] < nums[i]) {
            include = 1 + dfs(i + 1, i, nums);
        }

        int best = Math.max(exclude, include);
        dp[i][j + 1] = best;
        return best;
    }
}
