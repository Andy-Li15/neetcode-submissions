/*
freq tracks count of each uppercase letter

create sliding window while ensuring window is always valid

    left is used to remove elements
    right is used to add elements

    update freq with element from right
    get highest frequency (int highest)
    
    substring_size = (right - left + 1)
    replaceable = substring_size - highest
    if (replaceable <= k) 
        best = Math.max(best, substring_size)
        right++
    else window not valid
        decrement freq of left element
        left++ and right++
     
Optimization:
    if the previous window is invalid, 
        then length stays the same and highest doesn't matter
    if the previous window is valid and the new window is valid, 
        highest is the new char's freq
    So just let highest = Math.max(highest, freq[current char])
*/

class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int right = 0;
        int best = 0;
        int highest = 1;
        
        while (right < s.length()) {
            // increment char at right
            freq[s.charAt(right) - 'A']++;
            int length = right - left + 1;
            highest = Math.max(highest, freq[s.charAt(right) - 'A']);

            // find number of char to replace
            int replaceable = length - highest;
        
            if (replaceable <= k) {
                // valid substring, compare lengths
                best = Math.max(best, length);
                right++;
            } else {
                // invalid substring
                freq[s.charAt(left) - 'A']--;
                left++;
                right++;
            }

        }
        return best;

    }
}
