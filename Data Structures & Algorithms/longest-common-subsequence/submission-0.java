/*
Dynamic programming
dp[i][j] is the length of the longest common subsequence from text1[i] and text2[j]
*/
class Solution {
    int[][] dp;
    int n;
    int m;

    public int longestCommonSubsequence(String text1, String text2) {
        n = text1.length();
        m = text2.length();
        dp = new int[n + 1][m + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }
}
