class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int ways = 0;

        // dp[i] is the number of ways s can be decoded from index i to end (inclusive)
        // let dp[n] = 1
        // 

        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            char cur = s.charAt(i);
            if (cur == '0') {
                continue;
            }
            // take 1 char
            dp[i] = dp[i + 1];

            // try to take 2 chars
            if (i + 1 < n) {
                char next = s.charAt(i + 1);
                if (cur == '1' || cur == '2' && next >= '0' && next <= '6') {
                    dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];
    }
}
