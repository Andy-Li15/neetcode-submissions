/*
Use stack
Try to extend bars forward

add [index, height] of 1st element to stack
for each following element
    
    if height > stack.peek.height
        add [i, height] to stack
    if height == stack.peek.height
        do nothing
    if height < stack.peek.height
        int lastIndex = 0;
        while height < stack.peek.height
            int[] last = stack.pop
            best = Math.max(best, (last.height) * (i - last.index))
            lastIndex = last.index
        add [lastIndex, height] tot stack
*/
class Solution {

    Stack<int[]> stack;
    int best;

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0) return 0;

        stack = new Stack<>();
        stack.push(new int[]{0, heights[0]});

        best = 0;
        for (int i = 1; i < n; i++) {
            int height = heights[i];
            int[] top = stack.peek();
            
            // if new bar is taller, add to stack
            if (height > top[1]) stack.push(new int[]{i, height});
            // if new bar is same, do nothing
            // if new bar is shorter, pop taller bars and calculate potential area
            else if (height < top[1]) {
                popTallerBars(i, height);
            }
        }

        // pop remaining bars
        popTallerBars(n, 0);
        while (!stack.empty()) {
            int[] top = stack.pop();
            best = Math.max(best, top[1] * (n - top[0]));
        }

        return best;
        
    }

    private void popTallerBars(int i, int height) {
        int lastIndex = 0;
        int[] top = stack.pop();
        while (height < top[1]) {
            best = Math.max(best, top[1] * (i - top[0]));
            lastIndex = top[0];

            if (stack.empty()) break;
            top = stack.pop();
        }
        stack.push(new int[]{lastIndex, height});
    }
}
