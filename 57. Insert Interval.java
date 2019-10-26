class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals==null || intervals.length==0) {
            int[][] ans = {newInterval};
            return ans;
        }
        if (newInterval==null || newInterval.length==0) {
            return intervals;
        }
        boolean flag = true;
        LinkedList<int[]> ls = new LinkedList<>();
        for (int i=0; i<intervals.length; i++) {
            int[] temp = intervals[i];
            if (temp[1] < newInterval[0]) {
                ls.add(temp);
            } else if (temp[0] > newInterval[1]) {
                if (flag) {
                    ls.add(newInterval);
                    flag = false;
                }
                ls.add(temp);
            } else {
                newInterval[0] = Math.min(temp[0], newInterval[0]);
                newInterval[1] = Math.max(temp[1], newInterval[1]);
            }
        }
        if (flag) {
            ls.add(newInterval);
            flag = false;
        }
        return ls.toArray(new int[ls.size()][2]);
    }
}