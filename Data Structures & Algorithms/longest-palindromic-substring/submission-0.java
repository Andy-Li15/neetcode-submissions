/*
find even and odd palindromes separately

or use 2d dp, dp[a][b] = string from [a, b)
a string is a palindrome if the string within is a palindrome and the end chars are the same
*/
class Solution {
    public String longestPalindrome(String s) {
        int bestLength = 0;
        int[] bestIndex = new int[2];
        int n = s.length();

        // dp[i][j] == true if s.substring(i, j) is a palindrome
        // dp[i][j] == true if the ends of the substring are equal and the inner substring is a palindrome
        // dp[i][j] == true if substring is 1 char long or substring is 2 chars and both chars are equal
        boolean[][] dp = new boolean[n + 1][n + 1];

        // fill dp table while tracking best
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                if (s.charAt(i) == s.charAt(j - 1) && (j - i <= 3 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (bestLength < j - i) {
                        bestLength = j - i;
                        bestIndex[0] = i;
                        bestIndex[1] = j;
                    }
                }
            }
        }

        return s.substring(bestIndex[0], bestIndex[1]);
    }
}
