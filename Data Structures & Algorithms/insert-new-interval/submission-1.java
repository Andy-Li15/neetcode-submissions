class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i = 0;
        List<int[]> result = new ArrayList<>();

        // add intervals completely before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // merge overlapping intervals
        while (i < n && isOverlapping(intervals[i], newInterval)) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result.add(newInterval);

        // add remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    private boolean isOverlapping(int[] a, int[] b) {
        if (a[0] < b[0]) return a[1] >= b[0];
        return b[1] >= a[0];
    }
}
