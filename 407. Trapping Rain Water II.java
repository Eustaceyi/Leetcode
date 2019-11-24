class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap==null || heightMap.length==0 || heightMap[0].length==0) return 0;
        int row = heightMap.length; int col = heightMap[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        HashSet<Integer> seen = new HashSet<>();
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        int currmax = 0, ans = 0;

        for (int i=0; i<row; i++) {
            pq.offer(new int[] {heightMap[i][0], i, 0});
            seen.add(i*col);
            pq.offer(new int[] {heightMap[i][col-1], i, col-1});
            seen.add(i*col+col-1);
        }
        for (int j=1; j<col-1; j++) {
            pq.offer(new int[] {heightMap[0][j], 0, j});
            seen.add(j);
            pq.offer(new int[] {heightMap[row-1][j], row-1, j});
            seen.add((row-1)*col+j);
        }

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            currmax = Math.max(curr[0], currmax);
            int r = curr[1], c = curr[2];
            for (int i=0; i<4; i++) {
                int nextRow = r + dx[i];
                int nextCol = c + dy[i];
                if (nextRow < 0 || nextRow >= row || nextCol < 0 || nextCol >= col) {
                    continue;
                }
                if (!seen.contains(nextRow*col+nextCol)) {
                    if (heightMap[nextRow][nextCol] < currmax) {
                        ans += currmax - heightMap[nextRow][nextCol];
                    }
                    pq.offer(new int[] {heightMap[nextRow][nextCol], nextRow, nextCol});
                    seen.add(nextRow*col+nextCol);
                }
            }
        }
        return ans;
    }
}