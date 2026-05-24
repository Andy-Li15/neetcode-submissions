/*
Since array is rotated sorted, left or right half must be sorted
Two options
if (mid <= right), then right half sorted
if (left <= mid), then left half sorted

if (mid <= right), right half is sorted
    min = Math.min(min, nums[mid])
    right = mid - 1
else, left half is sorted
    min = Math.min(min, nums[left])
    left = mid + 1


*/
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 0) throw new IllegalArgumentException();

        int left = 0;
        int right = n - 1;
        int min = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = nums[mid];
            int rightVal = nums[right];
            if (midVal <= rightVal) {
                // right half sorted
                min = Math.min(min, midVal);
                right = mid - 1;
            } else {
                // left half sorted
                int leftVal = nums[left];
                min = Math.min(min, leftVal);
                left = mid + 1;
            }
        }
        
        return min;
    }
}
