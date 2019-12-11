class Solution {
    /**
     * This use heap to poll the smallest from row and then add the next column into the heap,
     * this could work since each row and each column is sorted.
     * Time klog(m)
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) {
            return 0;
        }
        int row = matrix.length, col = matrix[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int i=0; i<row; i++) {
            pq.offer(new Tuple(matrix[i][0], i, 0));
        }
        while (k > 1) {
            Tuple temp = pq.poll();
            if (temp.col < col-1) {
                pq.offer(new Tuple(matrix[temp.row][temp.col+1], temp.row, temp.col+1));
            }
            k--;
        }
        return pq.poll().val;
    }
}

class Tuple implements Comparable<Tuple> {
    int val;
    int row;
    int col;
    
    public Tuple(int val, int row, int col) {
        this.val = val;
        this.row = row;
        this.col = col;
    }
    
    @Override
    public int compareTo(Tuple that) {
        return this.val - that.val;
    }
}

/**
 * This is a binary search version,
 * key point is to figure out the search region
 * in this question, the search region is not the index, but the range from the smallest to the largest
 * and in each part we calculate the count of the number smaller than mid
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) {
            return 0;
        }
        int row = matrix.length, col = matrix[0].length;
        int lo = matrix[0][0], hi = matrix[row-1][col-1]+1;
        while (lo < hi) {
            int mid = (hi-lo)/2+lo;
            int count = 0;
            int j = col-1;
            for (int i=0; i<row; i++) {
                while (j>=0 && matrix[i][j] > mid) {j--;}
                count += j+1;
            }
            if (count < k) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}