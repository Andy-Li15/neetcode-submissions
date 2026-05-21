class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] str = s.toCharArray();
        while (left < right) {
            // check left char if ready
            char l = str[left];
            if (!((l >= 'A' && l <= 'Z') || (l >= '0' && l <= '9'))) { // not upper/num
                if (l >= 'a' && l <= 'z') { // lowercase char, convert to upper
                    str[left] -= 32;
                } else { // non alphanumeric, skip
                    left++;
                }
                continue;
            }

            // check right char if ready
            char r = str[right];
            if (!((r >= 'A' && r <= 'Z') || (r >= '0' && r <= '9'))) { // not upper/num
                if (r >= 'a' && r <= 'z') { // lowercase char, convert to upper
                    str[right] -= 32;
                } else { // non alphanumeric, skip
                    right--;
                }
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
