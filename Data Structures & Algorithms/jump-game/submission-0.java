class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] canReach = new boolean[n];
        canReach[0] = true;
        int furthest = 0;

        for (int i = 0; i < n && canReach[i]; i++) {
            // if furthest reach of current index is less then current furthest, skip
            if (i + nums[i] <= furthest) {
                continue;
            }
            furthest = Math.max(furthest, i + nums[i]);

            for (int j = 0; j <= nums[i] && i + j < n; j++) {
                canReach[i + j] = true;
            }
        }
        return canReach[n - 1];
    }
}
