/*
at least n+1 unique tasks for no idling
prioritize more common tasks
exact task name does not matter

count frequencies with int[]
track frequencies with PriorityQueue (max heap)
use array to track tasks in current group
*/
class Solution {

    public int leastInterval(char[] tasks, int n) {
        // count freqs
        int[] freq = new int[26];        
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        // find most frequent
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for (int i : freq) {
            if (i > 0) pq.add(i);
        }

        // pair tasks
        int cycles = 0;
        ArrayList<Integer> array = new ArrayList<>();
        n++;
        while (!pq.isEmpty()) {
            array.clear();

            // find most frequent tasks, up to n + 1 tasks
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (pq.isEmpty()) break;
                int count = pq.poll();
                array.add(count);
                min = Math.min(min, count);
            }
            
            // ensure tasks do not fall more than 1 below next most frequent task
            if (!pq.isEmpty()) {
                int next = pq.poll();
                min = Math.min(min, min - next + 1);
                pq.add(next);
            }

            // put unpaired tasks back in pq
            for (int i = 0; i < array.size(); i++) {
                int remaining = array.get(i) - min;
                if (remaining > 0) pq.add(remaining);
            }

            // update cycles, skip idling at end if no more tasks left
            cycles += min * n;
            if (pq.isEmpty()) cycles -= (n - array.size());
        }
        return cycles;
    }
}




