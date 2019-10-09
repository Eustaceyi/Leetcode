class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        '''
        keep a monotonic queue/stack for max value for window size k
        so use a deque for both pop from left O(1) and pop from right O(1)
        '''
        if len(nums) * k == 0:
            return []
        if k == 1:
            return nums
        deq = collections.deque()
        res = []
        for i in range(len(nums)):
            while deq and deq[0] <= i-k:
                deq.popleft()
            while deq and nums[deq[-1]] <= nums[i]:
                deq.pop()
            deq.append(i)
            if i >= k-1:
                res.append(nums[deq[0]])
        return res