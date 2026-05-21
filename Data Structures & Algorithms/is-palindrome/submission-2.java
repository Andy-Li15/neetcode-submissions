class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // check left char if ready
            char l = s.charAt(left);
            if (!((l >= 'A' && l <= 'Z') || (l >= '0' && l <= '9') || (l >= 'a' && l <= 'z'))) { // not alphanum
                left++;
                continue;
            }

            // check right char if ready
            char r = s.charAt(right);
            if (!((r >= 'A' && r <= 'Z') || (r >= '0' && r <= '9') || (r >= 'a' && r <= 'z'))) { // not alphanum
                right--;
                continue;
            }

            // compare and move onto next pair of chars
            // test same case, lower l and upper r, lower r and upper l
            if ((l == r || l >= 'a' && l - 32 == r || r >= 'a' && r - 32 == l)) {  
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
