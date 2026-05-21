/*
Claude AI solution
*/
class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;
        
        for (int i = 0, n = s.length(); i < n; i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(': stack[++top] = ')'; break;
                case '{': stack[++top] = '}'; break;
                case '[': stack[++top] = ']'; break;
                default:
                    if (top < 0 || stack[top--] != c) return false;
            }
        }
        return top < 0;
    }
}