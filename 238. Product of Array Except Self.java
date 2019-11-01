class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums==null || nums.length==0) {
            return new int[0];
        }
        int[] output = new int[nums.length];
        output[0] = 1;
        for (int i=1; i<nums.length; i++) {
            output[i] = output[i-1] * nums[i-1];
        }
        int temp = 1;
        for (int i=nums.length-2; i>=0; i--) {
            temp *= nums[i+1];
            output[i] *= temp;
        }
        return output;
    }
}