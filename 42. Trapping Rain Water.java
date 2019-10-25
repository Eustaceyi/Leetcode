class Solution {
    public int trap(int[] height) {
        if (height==null || height.length==0) return 0;
        int n = height.length;
        int[] LtoR = new int[n];
        int[] RtoL = new int[n];
        LtoR[0] = height[0];
        RtoL[n-1] = height[n-1];
        for (int i=1; i<n; i++) {
            LtoR[i] = Math.max(LtoR[i-1], height[i]);
            RtoL[n-i-1] = Math.max(RtoL[n-i], height[n-i]);
        }
        int ans=0;
        for (int i=0; i<n; i++) {
            int temp = Math.min(LtoR[i], RtoL[i]) - height[i];
            if (temp > 0) {
                ans += temp;
            }
        }
        return ans;
    }
}