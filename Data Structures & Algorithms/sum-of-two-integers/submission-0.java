class Solution {
    public int getSum(int a, int b) {
        int carry = 0;
        int res = 0;
        // check ith bit
        for (int i = 0; i < 32; i++) {
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            res |= ((bitA ^ bitB ^ carry) << i);
            // if 3 or 0 bits, nothing changes
            if (bitA == 1 && bitB == 1 || bitA == 1 && carry == 1 || bitB == 1 && carry == 1) { 
                // 2 bits
                carry = 1;
            } else if (bitA == 1 || bitB == 1 || carry == 1) {
                // 1 bit
                carry = 0;
            }
        }

        if (res > 0x7FFFFFFF) {
            res = ~(res ^ 0xFFFFFFFF);
        }
        return res;
    }
}
