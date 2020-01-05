class Solution {
    int n;
    List<List<String>> ans;
    boolean[] colSeen, diagSeen, revSeen;
    class Pair {
        int row;
        int col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        colSeen = new boolean[n];
        diagSeen = new boolean[2*n+1];
        revSeen = new boolean[2*n+1];
        ans = new ArrayList<>();
        generate(new ArrayList<>(), n);
        return ans;
    }
    
    private void generate(List<Pair> pos, int left) {
        if (left == 0) {
            ans.add(toBoard(pos));
            return;
        }
        int i = n-left;
        for (int j=0; j<n; j++) {
            if (colSeen[j]) {
                continue;
            }
            if (diagSeen[i-j+n-1]) {
                continue;
            }
            if (revSeen[i+j]) {
                continue;
            }
            pos.add(new Pair(i, j));
            colSeen[j] = true;
            diagSeen[i-j+n-1] = true;
            revSeen[i+j] = true;
            generate(pos, left-1);
            pos.remove(pos.size()-1);
            colSeen[j] = false;
            diagSeen[i-j+n-1] = false;
            revSeen[i+j] = false;
        }
    }
    
    private List<String> toBoard(List<Pair> pos) {
        List<String> temp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (Pair p : pos) {
            int col = p.col;
            for (int i=0; i<n; i++) {
                if (i==col) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            temp.add(sb.toString());
            sb.setLength(0);
        }
        return temp;
    }
}