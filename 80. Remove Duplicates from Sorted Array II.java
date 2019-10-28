class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums==null || nums.length<=2) {
            return nums.length;
        }
        int idx=2;
        for (int i=2; i<nums.length; i++) {
            if (nums[i] != nums[idx-2]) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums==null || nums.length<=2) {
            return nums.length;
        }
        int read=1, write=0, count=1;
        while (read < nums.length) {
            if (nums[read] == nums[write] && count >= 2) {
                read++;
            } else if (nums[read] == nums[write]) {
                nums[++write] = nums[read];
                count++;
                read++;
            } else if (nums[read] != nums[write]) {
                nums[++write] = nums[read];
                count = 1;
                read++;
            }
        }
        return write+1;
    }
}