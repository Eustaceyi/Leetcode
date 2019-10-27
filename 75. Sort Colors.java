class Solution {
    public void sortColors(int[] nums) {
        int zero=0, two=nums.length-1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                if (zero == i) {
                    continue;
                } else {
                    int temp = nums[zero];
                    nums[zero] = 0;
                    zero++;
                    nums[i] = temp;
                    i--;
                }
            } else if (nums[i] == 2) {
                if (i > two) {
                    break;
                } else {
                    int temp = nums[two];
                    nums[two] = 2;
                    two--;
                    nums[i] = temp;
                    i--;
                }
            }
        }
    }
}