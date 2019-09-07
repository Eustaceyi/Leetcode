class Solution:
    def minSubArrayLen(self, s: int, nums: List[int]) -> int:
        '''
        Sliding window O(n) time, O(1) space
        '''
        ans = 2**31-1
        left = 0
        sum = 0
        for i in range(len(nums)):
            sum += nums[i]
            while sum >= s:
                ans = min(ans, i - left + 1)
                sum -= nums[left]
                left += 1
                
        return ans if ans < 2**31-1 else 0

class Solution:
    '''
    Binary search O(nlogn) time, O(1) space
    '''
    def minSubArrayLen(self, s: int, nums: List[int]) -> int:
        result = len(nums) + 1
        for idx, n in enumerate(nums[1:], 1):
            nums[idx] = nums[idx - 1] + n
        left = 0
        for right, n in enumerate(nums):
            if n >= s:
                left = self.find_left(left, right, nums, s, n)
                result = min(result, right - left + 1)
        return result if result <= len(nums) else 0

    def find_left(self, left, right, nums, target, n):
        while left < right:
            mid = (left + right) // 2
            if n - nums[mid] >= target:
                left = mid + 1
            else:
                right = mid
        return left