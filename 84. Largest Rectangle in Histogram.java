/**
 * we use monotonic increasing stack to compute the largest area
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i=0; i<heights.length; i++) {
            // if we encounter a smaller bar, we can make sure that the taller ones cannot
            // be used into further higher calculation after this bar. So we pop them and 
            // calculate the max area
            while (stack.peek()!=-1 && heights[i] <= heights[stack.peek()]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i-stack.peek()-1));
            }
            stack.push(i);
        }
        // after we look through every bar, we now have a monotonic increasing stack,
        // we could do the process again to calculate the max area.
        while (stack.peek()!=-1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }
}