class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        // additional digit
        int[] newDigits = new int[digits.length + 1];
        System.arraycopy(digits, 0, newDigits, 1, digits.length);
        newDigits[0] = 1;
        return newDigits;
    }
}
