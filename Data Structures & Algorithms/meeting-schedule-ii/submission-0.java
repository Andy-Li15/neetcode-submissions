/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        if (n == 0) return 0;
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        ends.add(intervals.get(0).end);

        // if the earliest end conflicts with the current meeting, add new end as a new room
        for (int i = 1; i < n; i++) {
            Interval cur = intervals.get(i);
            if (ends.peek() > cur.start) {
                ends.add(cur.end);
            } else {
                ends.remove();
                ends.add(cur.end);
            }
        }

        return ends.size();

    }
}
