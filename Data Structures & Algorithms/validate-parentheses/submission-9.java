class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else {
                if (stack.empty()) return false;
                char val = stack.pop();
                if (c == ')' && val != '(') return false;
                if (c == '}' && val != '{') return false;
                if (c == ']' && val != '[') return false;
            }
        }
        return stack.empty();
    }
}
