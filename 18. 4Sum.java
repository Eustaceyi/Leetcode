class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int N = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i<N-3; i++) {
            if (i>0 && nums[i] == nums[i-1]) {
                    continue;
                }
            if(nums[i] + nums[N-1] + nums[N-2] + nums[N-1]<target) continue;
            if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3]>target) continue;
            for (int j = i+1; j<N-2; j++) {
                if (j>i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int st = j+1;
                int ed = N-1;
                while (st < ed) {
                    if (nums[st] + nums[ed] < target - nums[i] - nums[j]) {
                        while (st<ed && nums[st+1] == nums[st]) {
                            st++;
                        }
                        st++;
                    }
                    else if (nums[st] + nums[ed] > target - nums[i] - nums[j]) {
                        while (st<ed && nums[ed-1] == nums[ed]) {
                            ed--;
                        }
                        ed--;
                    }
                    else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[st], nums[ed]));
                        while (st<ed && nums[ed-1] == nums[ed]) {
                            ed--;
                        }
                        ed--;
                        while (st<ed && nums[st+1] == nums[st]) {
                            st++;
                        }
                        st++;
                    }
                }
            }
        }
        return result;
    }
}