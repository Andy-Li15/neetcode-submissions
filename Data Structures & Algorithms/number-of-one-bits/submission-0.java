class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        while (n > 0) {
            // add last bit
            res += n & 1;
            // remove last bit
            n >>= 1;
        }
        return res;
    }
}
