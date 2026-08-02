/*
each time, there are 2 choices: to open or to close
open only possible if number of open parentheses < remaining chars
close only possible if an open parentheses is available
then undo choice to simulate other choices
*/
class Solution {
    List<String> result;
    StringBuilder sb;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<String>();
        sb = new StringBuilder();
        generatePar(n, 0, 0);
        return result;
    }

    private void generatePar(int n, int open, int close) {
        // check if string formed
        if (close == n) {
            result.add(sb.toString());
            return;
        }
        // attempt to open, if open < remaining chars, then undo
        if (open < n) {
            sb.append('(');
            generatePar(n, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }
        // attempt to close, if open > 0, then undo
        if (close < open) {
            sb.append(')');
            generatePar(n, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);    
        }
    }
}
