class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1) return 0;
        int l = 0;
        int r = 1;
        int best = 0;
        while (r < n) {
            int rp = prices[r];
            int lp = prices[l];
            if (rp > lp) {
                best = Math.max(rp - lp, best);
            } else {
                l = r;
            }
            r++;
        }
        return best;
    }
}
