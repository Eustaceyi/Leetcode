class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        if (matrix==null || matrix.length==0){
            return ans;
        }
        int[] dirx = new int[] {0, 1, 0, -1};
        int[] diry = new int[] {1, 0, -1, 0};
        int row = matrix.length, col = matrix[0].length;
        int d = 0, x = 0, y = 0;
        HashSet<Integer> seen = new HashSet<>();
        for (int i=0; i<row*col; i++) {
            ans.add(matrix[x][y]);
            seen.add(x*col+y);
            boolean xcheck = (x + dirx[d] < 0) || (x + dirx[d] >= row);
            boolean ycheck = (y + diry[d] < 0) || (y + diry[d] >= col);
            boolean seencheck = seen.contains((x+dirx[d])*col+y+diry[d]);
            if (xcheck || ycheck || seencheck) {
                d = (d + 1) % 4;
            }
            x += dirx[d];
            y += diry[d];
        }
        return ans;
    }
}