class Solution {
    public int maxProduct(int[] nums) {
        int curMax = 1;
        int curMin = 1;
        int res = nums[0];

        for (int n : nums) {
            int temp = n * curMax;
            curMax = Math.max(Math.max(n * curMax, n * curMin), n);
            curMin = Math.min(Math.min(temp,       n * curMin), n);
            res = Math.max(res, curMax);
        }
        return res;
    }
}
