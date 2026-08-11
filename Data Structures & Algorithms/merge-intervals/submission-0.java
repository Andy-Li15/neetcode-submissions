/*
Sort intervals by first value
Merge intervals when possible
Add unmergeable intervals to result
Add final interval to result
return result as an array
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) return new int[][]{};

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        int[] interval = intervals[0];

        int i = 0;
        while (i < n) {
            int[] cur = intervals[i];
            if (isOverlapping(interval, cur)) {
                interval[0] = Math.min(interval[0], cur[0]);
                interval[1] = Math.max(interval[1], cur[1]);
            } else {
                result.add(interval);
                interval = cur;
            }
            i++;
        }
        result.add(interval);
        return result.toArray(new int[result.size()][]);

    }

    private boolean isOverlapping(int[] a, int[] b) {
        if (a[0] <= b[0]) {
            return a[1] >= b[0];
        }
        return b[1] >= a[0];
    }
}
