/*
use dp
dp[0] = 0
dp[1] = 1
dp[2] = 2
dp[3] = dp[1] + dp[2]
    add [2] to dp[1] or add [1] to dp[2]
    each solution in dp[1] and dp[2] add 1 to the number of solutions in dp[3]
*/
class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
