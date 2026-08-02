class Solution {
    private List<String> result;
    private StringBuilder sb;
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        sb = new StringBuilder();

        if (digits.length() == 0) {
            return result;
        }
        getCombinations(digits, 0);
        return result;
    }

    private void getCombinations(String digits, int index) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        char digit = digits.charAt(index);
        index++;
        for (char c : digitToChar[digit - '0'].toCharArray()) {
            sb.append(c);
            getCombinations(digits, index);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
