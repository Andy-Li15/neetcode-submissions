class Solution {

    private record Pair(int temp, int index) {}

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        if (n == 1) return new int[]{0};

        int[] result = new int[n];
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int val = temperatures[i];
            while (!stack.empty() && val > stack.peek().temp()) {
                Pair popped = stack.pop();
                result[popped.index()] = i - popped.index();
            }
            stack.push(new Pair(temperatures[i], i));
        }
        return result;
    }
}
