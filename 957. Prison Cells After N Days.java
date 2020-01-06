class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        t(cells);
        int count = (N-1) % 14;
        for (int i=0; i<count; i++) {
            t(cells);
        }
        return cells;
    }
    
    private void t(int[] cells) {
        if (cells[0] == 1) {
            cells[0] = 2;
        }
        if (cells[7] == 1) {
            cells[7] = 2;
        }
        for (int i=1; i<7; i++) {
            if (cells[i-1] > 0 && cells[i+1] > 0) {
                if (cells[i] == 0) {
                    cells[i] = -1;
                }
            } else if (cells[i-1] <= 0 && cells[i+1] <= 0) {
                if (cells[i] == 0) {
                    cells[i] = -1;
                }
            } else {
                if (cells[i] == 1) {
                    cells[i] = 2;
                }
            }
        }
        for (int i=0; i<8; i++) {
            if (cells[i] == 2) {
                cells[i] = 0;
            } else if (cells[i] == -1) {
                cells[i] = 1;
            }
        }
    }
}