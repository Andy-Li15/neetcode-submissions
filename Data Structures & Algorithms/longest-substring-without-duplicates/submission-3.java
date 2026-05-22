class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] prev = new int[128];
        Arrays.fill(prev, -1);
        int l = 0; // start index, inclusive
        int r = 1; // end index, inclusive
        int longest = 1;
        prev[s.charAt(0)] = 0;

        while (r < n) {
            char c = s.charAt(r);
            // update left if necessary
            if (prev[c] >= l) {
                l = prev[c] + 1;
            }
            // update prev
            prev[c] = r;

            longest = Math.max(longest, r - l + 1);

            r++;
        }
        return longest;
    }
}
