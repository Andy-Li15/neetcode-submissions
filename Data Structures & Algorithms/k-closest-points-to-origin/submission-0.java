// max heap to remove points furthest from origin
// store [x, y, dist] in pq
class Solution {

    private record PointData(int x, int y, double dist) {}

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<PointData> pq = new PriorityQueue<>((a,b) -> Double.compare(b.dist(), a.dist()));
        
        // find k closest points
        for (int[] point : points) {
            double dist = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
            pq.add(new PointData(point[0], point[1], dist));
            if (pq.size() > k) pq.remove();
        }

        // return k closest points
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            PointData point = pq.remove();
            result[i][0] = point.x();
            result[i][1] = point.y();
        }
        return result;
    }
}
