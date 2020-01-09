/**
 * O(n) time O(n) space solution
 * use quick select to find out median
 * and then put items into array
 * mind that we should put the median into two ends of array
 */
class Solution {
    public void wiggleSort(int[] nums) {
        int med = median(nums, nums.length/2, 0, nums.length-1);
        int[] temp = new int[nums.length];
        int even = 1;
        int odd = nums.length%2==0? nums.length-2 : nums.length-1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] < med) {
                temp[odd] = nums[i];
                odd-=2;
            }
            if (nums[i] > med) {
                temp[even] = nums[i];
                even+=2;
            }
        }
        while (odd >= 0) {
            temp[odd] = med;
            odd-=2;
        }
        while (even < nums.length) {
            temp[even] = med;
            even+=2;
        }
        for (int i=0; i<nums.length; i++) {
            nums[i] = temp[i];
        }
    }
    
    private int median(int[] nums, int pos, int st, int end) {
        int lo = st, hi = end;
        int pivot = nums[end];
        while (lo < hi) {
            if (nums[lo] > pivot) {
                int temp = nums[lo];
                nums[lo] = nums[--hi];
                nums[hi] = temp;
            } else {
                lo++;
            }
        }
        nums[end] = nums[lo];
        nums[lo] = pivot;
        if (lo == pos) {
            return nums[lo];
        } else if (lo < pos) {
            return median(nums, pos, lo+1, end);
        } else {
            return median(nums, pos, st, lo-1);
        }
    }
}