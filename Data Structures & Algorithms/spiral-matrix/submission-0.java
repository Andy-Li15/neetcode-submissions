class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // track top, bottom, left, right indexes
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        List<Integer> result = new ArrayList<>();
        while (true) {
            // top row
            if (left > right || top > bottom) break;
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            
            // right col
            if (left > right || top > bottom) break;
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            
            // bottom row
            if (left > right || top > bottom) break;
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;
            
            // left col
            if (left > right || top > bottom) break;
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }

        return result;
    }
}
