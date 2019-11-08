/**
 * BFS solution
 * Time O(n)
 * Space O(n)
 */
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        Deque<Integer> dq = new ArrayDeque<>();
        int r = image.length, c = image[0].length;
        int oriColor = image[sr][sc];
        image[sr][sc] = newColor;
        dq.offer(sr*c+sc);
        while (!dq.isEmpty()) {
            int p = dq.poll();
            int pr = p / c, pc = p % c;
            if (pr > 0 && image[pr-1][pc] == oriColor) {
                image[pr-1][pc] = newColor;
                dq.offer((pr-1)*c+pc);
            }
            if (pr < r-1 && image[pr+1][pc] == oriColor) {
                image[pr+1][pc] = newColor;
                dq.offer((pr+1)*c+pc);
            }
            if (pc > 0 && image[pr][pc-1] == oriColor) {
                image[pr][pc-1] = newColor;
                dq.offer(pr*c+pc-1);
            }
            if (pc < c-1 && image[pr][pc+1] == oriColor) {
                image[pr][pc+1] = newColor;
                dq.offer(pr*c+pc+1);
            }
        }
        return image;
    }
}