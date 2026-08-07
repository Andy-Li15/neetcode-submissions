class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        // dp[i][j] == true 
        //      iff s.substring(i, j + 1) is a palindrome
        //      iff ends of substring are the same and length <= 3
        //      iff ends of substring are the same and inner string is palindrome
        // i and j are inclusive

        // fill dp
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
