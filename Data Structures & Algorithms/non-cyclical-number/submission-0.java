class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while (!seen.contains(n)) {
            seen.add(n);
            n = happify(n);
            if (n == 1) return true;
        }
        return false;
    }
    
    private int happify(int n) {
        int total = 0;
        while (n > 0) {
            int digit = n % 10;
            total += digit * digit;
            n /= 10;
        }
        return total;
    }
}
