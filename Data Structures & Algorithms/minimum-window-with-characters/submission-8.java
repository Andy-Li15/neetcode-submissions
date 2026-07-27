/*
let freq1 and freq2 be HashMaps
get freq1 of t
use freq2 for s

left = 0, right = 0
    left index <= substring <= right index

skip letters not in t

increment right and attempt to match freq2 to freq1

diff++ for each unique char in t
diff-- each time freq2(c) == freq1(c)
when freq2 matches freq1, diff == 0

when diff == 0
    increment left until substring no longer valid
    record new best if one is found
    increment left one past last valid substring
*/
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        // get frequency of t
        int diff = 0;
        HashMap<Character, Integer> freq1 = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (freq1.containsKey(c)) {
                freq1.put(c, freq1.get(c) + 1);
            } else {
                diff++;
                freq1.put(c, 1);            
            }
        }

        // sliding window
        HashMap<Character, Integer> freq2 = new HashMap<>();
        int left = 0;
        int right = 0;

        // skip letters not in t
        while (right < s.length() && !freq1.containsKey(s.charAt(right))) {
            left++;
            right++;
        }
        if (t.length() > (s.length() - right)) return "";

        // find shortest substring
        String best = "";
        while (right < s.length()) {
            // process char at right
            char c = s.charAt(right);
            freq2.put(c, freq2.getOrDefault(c, 0) + 1);
            if (freq1.containsKey(c) && freq2.get(c) == freq1.get(c)) diff--;

            // a substring found
            // skip left chars until substring no longer valid
            while (diff == 0 && left <= right) {
                c = s.charAt(left);
                freq2.put(c, freq2.getOrDefault(c, 0) - 1);
                if (freq1.containsKey(c) && freq2.get(c) < freq1.get(c)) { // last valid substring
                    diff++;
                    if (best.length() > (right - left + 1) || best.length() == 0) {
                        best = s.substring(left, right + 1);
                    }
                } 
                left++;
            }

            right++;
        }

        return best;
    }
}
