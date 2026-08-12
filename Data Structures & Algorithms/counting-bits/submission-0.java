class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        for (int i = 1; i <= n; i++) {
            // result[i] = result(rightshifted i) + last bit that was rightshifted
            result[i] = (i & 1) + result[i >> 1];
        }
        return result;
    }
}
