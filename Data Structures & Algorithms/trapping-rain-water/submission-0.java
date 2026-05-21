/*
Prefix max: p[i] is the highest wall before i
Suffix max: s[i] is the highest wall after i
*/
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];

        prefixMax[0] = 0;
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], height[i - 1]);
        }

        suffixMax[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], height[i + 1]);
        }

        int water = 0;
        for (int i = 0; i < n; i++) {
            int trapped = Math.max(
                Math.min(prefixMax[i], suffixMax[i]) - height[i], 0);
            water += trapped;
        }
        return water;
    }
}
