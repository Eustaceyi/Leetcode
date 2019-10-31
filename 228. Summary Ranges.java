class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums==null || nums.length==0) {
            return ans;
        } else if (nums.length==1) {
            ans.add(String.valueOf(nums[0]));
            return ans;
        }
        int start=nums[0], end = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] - end == 1) {
                end = nums[i];
            } else {
                if (end==start) {
                    ans.add(String.valueOf(start)); 
                } else {
                    ans.add(String.valueOf(start) + "->" + String.valueOf(end));
                }
                start = nums[i];
                end = nums[i];
            }
        }
        if (end==start) {
                    ans.add(String.valueOf(start));
        } else {
            ans.add(String.valueOf(start) + "->" + String.valueOf(end));
        }
        return ans;
    }
}