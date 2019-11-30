/**
 * O(n^2) solution with dp
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        int[] ans = new int[nums.length];
        for (int ind=ans.length-1; ind>=0; ind--) {
            int temp = nums[ind];
            int maxlen = 0;
            for (int i=ind; i<nums.length; i++) {
                if (nums[i] > temp) {
                    maxlen = Math.max(maxlen, ans[i]);
                }
            }
            ans[ind] = maxlen + 1;
        }
        int res = 0;
        for (int i=0; i<ans.length; i++) {
            res = Math.max(res, ans[i]);
        }
        return res;
    }
}
/**
 * Keep the tail array as the smallest end of length i longest increasing subsequence
 * for each element in nums:
 * (1) if x is larger than all tails, append it, increase the size by 1
 * (2) if tails[i-1] < x <= tails[i], update tails[i]
 * Time O(logn)
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        int[] tail = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int lo=0, hi=size;
            while (lo < hi) {
                int mid = (hi-lo)/2+lo;
                if (tail[mid] < x) {
                    lo = mid+1;
                } else {
                    hi = mid;
                }
            }
            tail[lo] = x;
            if (lo == size) {
                size++;
            }
        }
        return size;
    }
}