class Solution {
    public int search(int[] nums, int target) {
        short l = 0;
        short r = (short)(nums.length - 1);
        while (l <= r) {
            short mid = (short)((l + r) / 2);
            int val = nums[mid];
            if (target == val) return mid;
            else if (target > val) l = (short)(mid + 1);
            else r = (short)(mid - 1);
        }
        return -1;
    }
}
