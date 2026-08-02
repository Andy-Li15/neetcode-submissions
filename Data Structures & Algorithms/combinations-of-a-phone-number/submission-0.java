class Solution {
    List<String> result;
    StringBuilder sb;

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
        switch(digit) {
            case '2':
                testLetter(digits, index, 'a');
                testLetter(digits, index, 'b');
                testLetter(digits, index, 'c');
                break;
            case '3':
                testLetter(digits, index, 'd');
                testLetter(digits, index, 'e');
                testLetter(digits, index, 'f');
                break;
            case '4':
                testLetter(digits, index, 'g');
                testLetter(digits, index, 'h');
                testLetter(digits, index, 'i');
                break;
            case '5':
                testLetter(digits, index, 'j');
                testLetter(digits, index, 'k');
                testLetter(digits, index, 'l');
                break;
            case '6':
                testLetter(digits, index, 'm');
                testLetter(digits, index, 'n');
                testLetter(digits, index, 'o');
                break;
            case '7':
                testLetter(digits, index, 'p');
                testLetter(digits, index, 'q');
                testLetter(digits, index, 'r');
                testLetter(digits, index, 's');
                break;
            case '8':
                testLetter(digits, index, 't');
                testLetter(digits, index, 'u');
                testLetter(digits, index, 'v');
                break;
            case '9':
                testLetter(digits, index, 'w');
                testLetter(digits, index, 'x');
                testLetter(digits, index, 'y');
                testLetter(digits, index, 'z');
                break;
        }
    }

    private void testLetter(String digits, int index, char letter) {
        sb.append(letter);
        getCombinations(digits, index);
        sb.deleteCharAt(sb.length() - 1);
    }
}
