/*
Since array is rotated sorted
    left half of array must be sorted, or right half of array must be sorted

if (nums[mid] == target) return mid;
if (nums[mid] <= nums[right]), then right half is sorted
    if (nums[mid] <= target <= nums[right]) left = mid;
    else right = mid - 1;
else, left half is sorted
    if (nums[left] <= target <= nums[mid]) right = mid;
    else left = mid + 1;
*/
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;

        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = nums[mid];
            int rightVal = nums[right];
            int leftVal = nums[left];
            if (midVal == target) return mid;
            if (midVal <= rightVal) {
                // right half sorted
                if (midVal <= target && target <= rightVal) left = mid + 1;
                else right = mid - 1;
            } else {
                if (leftVal <= target && target <= midVal) right = mid - 1;
                else left = mid + 1;
            }
        }
        return -1;
    }
}
