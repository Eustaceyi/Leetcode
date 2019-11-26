class Solution {
    /**
     * Idea is keeping a monotonic stack for recording the max
     * and here we use deque is for we can poll from head and this
     * provides that we can get rid of maxes that are out of ranges.
     * Time O(n) Space O(n)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums==null || nums.length==0 || k ==0) {
            return new int[0];
        }
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[nums.length-k+1];
        for (int i=0; i<nums.length; i++) {
            // removing elements that are further than k
            while (!dq.isEmpty() && dq.peekFirst() < i-k+1) {
                dq.pollFirst();
            }
            // removing elements that smaller than current offer one
            // since they are not helping with the max
            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.pollLast();
            }
            // offer the current element and record the answer
            dq.offerLast(i);
            if (i >= k-1) {
                ans[i-k+1] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
    /**
     * The pq solution Time O(nlogk) Space O(k)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums==null || nums.length==0 || k ==0) {
            return new int[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] ans = new int[nums.length-k+1];
        for (int i=0; i<nums.length; i++) {
            pq.offer(nums[i]);
            if (i >= k-1) {
                ans[i-k+1] = pq.peek();
                pq.remove(nums[i-k+1]);
            }
        }
        return ans;
    }
}