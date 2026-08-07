/*
Dynamic programming
dp[i] is the min number of coins needed to make i
from each i, attempt to add each coin value and see if it uses a smaller number of coins
    dp[i + amount] = Math.min(dp[i + amount], dp[i] + 1);
return dp[amount]

*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        // prepare dp
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        // sort coins so we know when coins are too large
        Arrays.sort(coins);

        // fill dp
        int n = coins.length;
        for (int i = 0; i < amount; i++) {
            // if no combination of coins making i, continue
            if (dp[i] > amount) continue;
            // if coins are too large, break loop
            if (i + coins[0] > amount) break;

            for (int j = 0; j < n; j++) {
                int value = coins[j];

                // if coins are too large, break loop
                if (i + value > amount || i + value < i) {
                    break;
                }

                // see if using coin creates more efficient combination
                dp[i + value] = Math.min(dp[i + value], dp[i] + 1);
            }
        }
        
        return (dp[amount] <= amount) ? dp[amount] : -1;
    }
}
