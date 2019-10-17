class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i:nums) {
            set.add(i);
        }
        int res = 0;
        for (int i=0;i<=nums.length;i++) {
            if (!set.contains(i)) {
                res = i;
                break;
            }
        }
        return res;
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return len*(len+1)/2 - sum;
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i=0;i<nums.length;i++) {
            n ^= i ^ nums[i];
        }
        return n;
    }
}