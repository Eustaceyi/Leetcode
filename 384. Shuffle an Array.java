class Solution {
    Random r;
    int[] shuffled;
    int[] nums;
    int size;

    public Solution(int[] nums) {
        r = new Random();
        this.nums = nums;
        size = nums.length;
        shuffled = new int[size];
        for (int i=0; i<size; i++) {
            shuffled[i] = nums[i];
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i=0; i<size; i++) {
            int ii = r.nextInt(size-i);
            swap(shuffled, ii, i);
        }
        return shuffled;
    }
    
    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */