/*
O(N) runtime solution: 2 pointers left -> <- right
O(N) space solution: convert string to charArray
O(1) space solution: use string and account for upper/lower letters
*/
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // check left char if ready
            char l = s.charAt(left);
            if (l >= 'a' && l <= 'z') l -= 32; // lower uppercase letters
            if (!((l >= 'A' && l <= 'Z') || (l >= '0' && l <= '9'))) { // not alphanum
                left++;
                continue;
            }

            // check right char if ready
            char r = s.charAt(right);
            if (r >= 'a' && r <= 'z') r -= 32; // lower uppercase letters
            if (!((r >= 'A' && r <= 'Z') || (r >= '0' && r <= '9'))) { // not alphanum
                right--;
                continue;
            }

            // compare and move onto next pair of chars
            if (l != r) return false;
            left++;
            right--;
        }
        return true;
    }
}
