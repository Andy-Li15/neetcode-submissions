class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // find row
        int l = 0;
        int r = m - 1;
        int row = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int minVal = matrix[mid][0];
            int maxVal = matrix[mid][n - 1];
            if (target < minVal) {
                r = mid - 1;
            } else if (target > maxVal) {
                l = mid + 1;
            } else {
                row = mid;
                break;
            }
        }
        if (row == -1) return false;

        // find target
        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midVal = matrix[row][mid];
            if (target < midVal) {
                r = mid - 1;
            } else if (target > midVal) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
