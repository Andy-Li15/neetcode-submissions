/*
Idea 1:
    Count frequencies of s1 in freq
    Remove first s1.length() characters from freq
    Pointer left adds to freq, right removes from freq
        left and right are incremented
    Return true when total(freq)

    This solution checks each frequency up to 26 times per character
    Optim 1: check only when freq[char] == 0
    Optim 2: keep track of diff chars
        diff++ when freq changes from 0, diff-- when freq changes to 0
*/
/*
diff optim:
    when a freq changes from 0, diff++
    when a freq changes to 0, diff--
    true only when diff == 0

*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 > l2) return false;

        int[] freq = new int[26];
        int diff = 0;
        
        // increment s1 freqs
        for (char c : s1.toCharArray()) {
            int index = c - 'a';
            if (freq[index] == 0) diff++;
            freq[index]++;
        }

        // decrement first s1.length() chars of s2
        for (int i = 0; i < l1; i++) {
            int index = s2.charAt(i) - 'a';
            if (freq[index] == 0) diff++;
            freq[index]--;
            if (freq[index] == 0) diff--;
        }
        if (diff == 0) return true;

        // increment left char, decrement right char
        // true if diff == 0
        for (int i = l1; i < l2; i++) {
            int left = s2.charAt(i - l1) - 'a';
            int right = s2.charAt(i) - 'a';

            if (freq[left] == 0) diff++;
            freq[left]++;
            if (freq[left] == 0) diff--;

            if (freq[right] == 0) diff++;
            freq[right]--;
            if (freq[right] == 0) diff--;

            if (diff == 0) return true;
        }
        return false;
    }
}
