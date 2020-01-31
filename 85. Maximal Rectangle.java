/**
 * borrow idea from largest rectangle area, we build rows
 * as histograms that indicates the height from the first 
 * row, and we calculate the row max area.
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null || matrix.length==0) {
            return 0;
        }
        int maxArea = 0;
        int[] dp = new int[matrix[0].length];
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(dp));
        }
        return maxArea;
    }
    
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i=0; i<heights.length; i++) {
            while (stack.peek()!=-1 && heights[i] <= heights[stack.peek()]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i-stack.peek()-1));
            }
            stack.push(i);
        }
        while (stack.peek()!=-1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }
}