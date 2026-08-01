/*
Idea: double priority queue

lower values/half go to max heap (pq1)
higher values/half go to min heap (pq2)

ensure difference between heap sizes <= 1
*/
class MedianFinder {

    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;

    public MedianFinder() {
        pq1 = new PriorityQueue<>((a,b) -> b - a);
        pq2 = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // check if num is in left half
        // add to pq1 if yes, add to pq2 if no
        if (pq1.isEmpty() || num < pq1.peek()) {
            pq1.add(num);
        } else {
            pq2.add(num);
        }

        // balance pqs
        if (pq1.size() - pq2.size() > 1) {
            int val = pq1.remove();
            pq2.add(val);
        }  else if (pq2.size() - pq1.size() > 1) {
            int val = pq2.remove();
            pq1.add(val);
        }
    }
    
    public double findMedian() {
        if (((pq1.size() + pq2.size()) & 1) == 0) { // even
            return (pq1.peek() + pq2.peek()) / 2.0;
        } else {                                    // oddd
            if (pq1.size() > pq2.size()) {
                return pq1.peek();
            } else {
                return pq2.peek();
            }
        }
    }
}
