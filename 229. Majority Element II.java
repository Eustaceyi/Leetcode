class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums==null || nums.length==0) {
            return new ArrayList<>();
        }
        int count1=0, count2=0, can1=0, can2=0;
        for (int i : nums) {
            if (i == can1) {
                count1++;
            } else if (i == can2) {
                count2++;
            } else if (count1 == 0) {
                can1 = i;
                count1++;
            } else if (count2 == 0) {
                can2 = i;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int i : nums) {
            if (i == can1) {
                count1++;
            } else if (i == can2) {
                count2++;
            }
        }
        if (count1 > nums.length/3) {
            ans.add(can1);
        }
        if (count2 > nums.length/3) {
            ans.add(can2);
        }
        return ans;
    }
}