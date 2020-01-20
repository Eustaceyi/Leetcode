class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums==null || nums.length==0) {
            return new ArrayList<>();
        }
        int len = nums.length;
        int[] dp = new int[len];
        int[] parent = new int[len];
        int maxpos = 0, maxlen = 0;
        
        Arrays.sort(nums);
        
        for (int i=0; i<len; i++) {
            dp[i] = 1;
            parent[i] = -1;
            for (int j=0; j<i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j]+1) {
                    dp[i] = dp[j]+1;
                    parent[i] = j;
                }
            }
            if (dp[i] > maxlen) {
                maxlen = dp[i];
                maxpos = i;
            }
        }
        
        List<Integer> ret = new ArrayList<>();
        while (maxpos != -1) {
            ret.add(nums[maxpos]);
            maxpos = parent[maxpos];
        }
        return ret;
    }
}