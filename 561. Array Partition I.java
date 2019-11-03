class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i=0; i<nums.length; i+=2) {
            ans += Math.min(nums[i], nums[i+1]);
        }
        return ans;
    }
}
/**
 * using count sort to do the sorting
 * Time O(n)
 * Space O(n)
 */
class Solution {
    public int arrayPairSum(int[] nums) {
        int[] countSort = new int[20001];
        for (int i : nums) {
            countSort[i+10000]++;
        }
        int sum=0; boolean odd=true;
        for (int i=-10000; i<=10000; i++) {
            while (countSort[i+10000] > 0) {
                if (odd) {
                    sum += i;
                }
                odd = !odd;
                countSort[i+10000]--;
            }
        }
        return sum;
    }
}