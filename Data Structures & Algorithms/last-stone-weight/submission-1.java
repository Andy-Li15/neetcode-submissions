class Solution {
    public int lastStoneWeight(int[] stones) {
        // add weights to pq
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for (int i : stones) {
            pq.add(i);
        }

        // simulate
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if (x != y) {
                pq.add(x - y);
            }
        }

        // return result
        if (pq.size() == 0) return 0;
        return pq.poll();
    }
}
