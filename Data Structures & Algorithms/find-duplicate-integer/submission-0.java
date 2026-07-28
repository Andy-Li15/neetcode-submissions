/*
if a num is found, set index (num - 1) to negative
if index (num - 1) is already negative, duplicate is num
reset all indexes of nums to positive
*/
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int dup = 0;
        for (int i = 0; i < n; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) {
                dup = Math.abs(nums[i]);
                break;
            }
            nums[Math.abs(nums[i]) - 1] *= -1;
        }

        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        return dup;
    }
}
