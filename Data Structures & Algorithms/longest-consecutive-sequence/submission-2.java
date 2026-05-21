/*
Idea: 
    hashset stores found values
    for each value, check if prev in hashset. 
        If yes, skip
        If no, find next until next not in hashset
        Then store best value found so far

*/
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int i : nums) {
            seen.add(i);
        }

        int best = 0;
        for (int i : seen) {
            if (seen.contains(i - 1)) continue;
            int cur = 1;
            while (seen.contains(i + 1)) {
                i++;
                cur++;
            }
            best = Math.max(best, cur);
        }
        return best;
    }
}
