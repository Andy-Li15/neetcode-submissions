/*
create frequency dist (HashMap) : O(N)
get top k elements using Priority Queue
add elements to array
*/
class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        // Make frequency distribution
        int n = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            if (!freq.containsKey(val)) freq.put(val, 0);
            freq.put(val, freq.get(val) + 1);
        }

        // Put in pq
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.add(entry);
        }

        // remove k most frequent elements
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.remove().getKey();
        }
        return result;
    }
}
