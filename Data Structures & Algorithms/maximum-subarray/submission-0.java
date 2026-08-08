class Solution {
    public int maxSubArray(int[] nums) {
        int best = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = cur + nums[i];
            // if cur is less than 0, compare best with nums[i]
            //      also set cur to 0 since if cur < 0, next > cur + next
            // if cur >= 0, compare best with cur
            if (cur < 0) {
                best = Math.max(best, nums[i]);
                cur = 0;
            } else {
                best = Math.max(best, cur);
            }
        }
        return best;
    }
}
