class Solution {
    /**
     * recursion 
     * Time O(2^n)
     * Space O(n)
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}

/**
 * Iterative method
 * Time O(2^n)
 * Space O(1)
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int i=0; i<nums.length; i++) {
            int size = ans.size();
            for (int j=0; j<size; j++) {
                List<Integer> temp = ans.get(j);
                temp.add(nums[i]);
                ans.add(new ArrayList(temp));
                temp.remove(temp.size()-1);
            }
        }
        return ans;
    }
}