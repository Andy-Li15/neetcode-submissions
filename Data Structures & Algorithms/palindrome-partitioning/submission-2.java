/*
each time there is a palindrome, there are 2 options
    partition the palindrome
    don't partition the palindrome
*/
class Solution {
    List<List<String>> result;
    List<String> subset;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        subset = new ArrayList<>();
        getSubsets(s, 0, 1);
        return result;
    }

    private void getSubsets(String s, int left, int right) {
        if (right >= s.length()) {
            if (isPalindrome(s, left, right)) {
                subset.add(s.substring(left, right));
                result.add(new ArrayList<>(subset));
                subset.remove(subset.size() - 1);
            }
            return;
        }

        if (isPalindrome(s, left, right)) {
            // try partitioning
            subset.add(s.substring(left, right));
            getSubsets(s, right, right + 1);
            subset.remove(subset.size() - 1);
        }
        // don't partition
        getSubsets(s, left, right + 1);
    }

    private boolean isPalindrome(String s, int left, int right) {
        right--;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
