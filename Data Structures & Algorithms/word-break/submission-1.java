/*
Dynamic programming

dp[i] == true if s can be segmented up to index i (inclusive)

fast checking with hashtable or trie?

HashSet approach: 
    get longest word in wordDict

    find next i where dp[i] == true
    for (int j = 1; j < longest; j++) {
        try to find s.substring(i, i + j) in hashSet
        if found, dp[i + j] == true;
    }
    return dp[s.length() - 1];
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int longest = 0;

        // make set of words
        HashSet<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
            longest = Math.max(longest, word.length());
        }

        // dp[i] == true if wordBreak is true up to index i (inclusive)
        boolean[] dp = new boolean[n];

        for (int i = 0; i < n; i++) {
            // find next index where i == 0 or dp[i - 1] == true
            if (i == 0 || dp[i - 1] == true) {
                // find valid words from i
                for (int j = 1; j <= longest && (i + j) <= n; j++) {
                    if (set.contains(s.substring(i, i + j))) {
                        dp[(i - 1) + j] = true;
                    }
                }
            }
        }

        return dp[n - 1];
    }
}
