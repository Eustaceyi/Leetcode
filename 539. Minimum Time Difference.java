class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] exist = new boolean[24*60];
        for (String s : timePoints) {
            String[] sp = s.split(":");
            int temp = Integer.parseInt(sp[0])*60 + Integer.parseInt(sp[1]);
            if (exist[temp]) {
                return 0;
            }
            exist[temp] = true;
        }
        int ans = 24*60;
        int prev = -1;
        for (int i=0; i<24*60; i++) {
            if (exist[i]) {
                if (prev >= 0) {
                    ans = Math.min(ans, i-prev);
                    prev = i;
                } else {
                    prev = i;
                }
            }
        }
        for (int i=0; i<24*60; i++) {
            if (exist[i]) {
                ans = Math.min(ans, i+24*60-prev);
            }
        }
        return ans;
    }
}