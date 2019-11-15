class Solution {
    public int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;
  
        for (int num : nums) {
            // first appearence: 
            // add num to seen_once 
            // don't add to seen_twice because of presence in seen_once
    
            // second appearance: 
            // remove num from seen_once 
            // add num to seen_twice
    
            // third appearance: 
            // don't add to seen_once because of presence in seen_twice
            // remove num from seen_twice
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }
        return seenOnce;
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for (int i=0; i<nums.length; i++) {
            if (map.get(nums[i]) == 1) {
                return nums[i];
            }
        }
        return -1;
    }
}