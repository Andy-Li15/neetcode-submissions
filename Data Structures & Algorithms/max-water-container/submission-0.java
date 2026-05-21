class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int result = 0;
        while (left < right) {
            int leftBar = heights[left];
            int rightBar = heights[right];
            result = Math.max(result, (right - left) * Math.min(leftBar, rightBar));
            if (leftBar < rightBar) left++;
            else right--;
        }
        return result;
    }
}
