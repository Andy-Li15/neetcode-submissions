class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push('(');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case '[':
                    stack.push('[');
                    break;
                default:
                    if (stack.empty()) return false;
                    char val = stack.pop();
                    switch(c) {
                        case ')':
                            if (val != '(') return false;
                            break;
                        case '}':
                            if (val != '{') return false;
                            break;
                        case ']':
                            if (val != '[') return false;
                            break;
                    }
            }
        }
        return stack.empty();
    }
}
