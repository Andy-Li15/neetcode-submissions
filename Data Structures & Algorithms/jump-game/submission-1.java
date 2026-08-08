class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] canReach = new boolean[n];
        canReach[0] = true;

        for (int i = 0; i < n && canReach[i]; i++) {
            for (int j = 0; j <= nums[i] && i + j < n; j++) {
                canReach[i + j] = true;
            }
        }
        return canReach[n - 1];
    }
}
