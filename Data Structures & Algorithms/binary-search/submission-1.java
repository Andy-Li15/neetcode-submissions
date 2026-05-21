class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid, val;
        while (l <= r) {
            mid = (l + r) / 2;
            val = nums[mid];
            if (target == val) return mid;
            else if (target > val) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}
