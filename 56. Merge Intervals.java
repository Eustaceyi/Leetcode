class Pair {
    public int key;
    public int value;
    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals==null || intervals.length==0) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    if (a[1] == b[1]) {
                        return 0;
                    } else {
                        return a[1] > b[1] ? 1 : -1;
                    }
                }
                return (a[0] > b[0]) ? 1 : -1;
            }
        });
        
        List<Pair> ls = new LinkedList<>();
        ls.add(new Pair(intervals[0][0], intervals[0][1]));
        for (int i=1; i<intervals.length; i++) {
            Pair temp = ls.get(ls.size()-1);
            int[] tocheck = intervals[i];
            if (tocheck[0] > temp.value) {
                ls.add(new Pair(tocheck[0], tocheck[1]));
            } else if (tocheck[1] > temp.value) {
                temp.value = tocheck[1];
            }
        }
        int[][] ans = new int[ls.size()][2];
        for (int i=0;i<ls.size();i++) {
            int key = ls.get(i).key;
            int value = ls.get(i).value;
            ans[i] = new int[] {key, value};
        }
        return ans;
    }
}