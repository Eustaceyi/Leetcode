class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i)+1);
            } else {
                map.put(i,1);
            }
            if (map.get(i) > n/2) {
                return i;
            }
        }
        return 0;
    }
}

/**
 * Boyer-Moore Voting Algorithm
 */
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int i : nums) {
            if (count == 0) {
                candidate = i;
                count++;
            } else {
                count += i==candidate ? 1 : -1;
            }   
        }
        return candidate;
    }
}