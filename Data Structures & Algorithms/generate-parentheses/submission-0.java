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
        generatePar(n, 0);
        return result;
    }

    private void generatePar(int n, int open) {
        // check if string formed
        if (sb.length() == 2*n) {
            result.add(sb.toString());
            return;
        }
        // attempt to open, if open < remaining chars, then undo
        if (open < (2*n - sb.length())) {
            sb.append('(');
            generatePar(n, open + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        // attempt to close, if open > 0, then undo
        if (open > 0) {
            sb.append(')');
            generatePar(n, open - 1);
            sb.deleteCharAt(sb.length() - 1);    
        }
    }
}
