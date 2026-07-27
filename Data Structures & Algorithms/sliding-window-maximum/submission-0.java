class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        int[] result = new int[nums.length - k + 1];
        result[0] = pq.peek();

        for (int i = 0; i < nums.length - k; i++) {
            pq.remove(nums[i]);
            pq.add(nums[i + k]);
            result[i + 1] = pq.peek();
        }

        return result;
    }
}
