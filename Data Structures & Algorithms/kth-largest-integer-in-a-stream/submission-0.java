// use min heap to find kth largest
// keep min heap at k elements, kth element is head
class KthLargest {

    PriorityQueue<Integer> pq;
    int k;


    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;

        for (int i : nums) {
            pq.add(i);
            if (pq.size() > k) {
                pq.remove();
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) {
            pq.remove();
        }
        return pq.peek();
    }
}
