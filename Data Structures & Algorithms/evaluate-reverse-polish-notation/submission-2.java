class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.length() == 1 && s.charAt(0) < 48)
                switch(s.charAt(0)) {
                    case '+' -> stack.push(stack.pop() + stack.pop());
                    case '-' -> {
                        int subtracted = stack.pop();
                        stack.push(stack.pop() - subtracted);
                    }
                    case '*' -> stack.push(stack.pop() * stack.pop());
                    case '/' -> {
                        int divisor = stack.pop();
                        stack.push(stack.pop() / divisor);
                    }
                }
            else stack.push(Integer.parseInt(s));
        }
        return stack.pop();
    }
}
