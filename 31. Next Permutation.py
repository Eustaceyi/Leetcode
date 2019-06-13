class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
        """
        if not nums or len(nums) == 1:
            return
        
        i = len(nums)-1
        while i > 0 and nums[i] <= nums[i-1]:
            i -= 1
        if i == 0:
            self.reverse(nums, 0, len(nums)-1)
            return
        
        toswap = i-1
        for i in range(len(nums)-1, toswap,-1):
            if nums[i] > nums[toswap]:
                nums[i], nums[toswap] = nums[toswap], nums[i]
                break
        self.reverse(nums, toswap+1, len(nums)-1)
        
    def reverse(self, nums, l, r):
        while l < r:
            nums[l], nums[r] = nums[r], nums[l]
            l += 1
            r -= 1