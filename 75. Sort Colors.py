class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        Dutch National Flag problem solution.
        for all idx < left : nums[idx < left] = 0
        curr is an index of element under consideration
        for all idx > right : nums[idx > right] = 2
        """
        left, curr = 0, 0
        right = len(nums)-1
        while curr <= right:
            if nums[curr] == 0:
                nums[left], nums[curr] = nums[curr], nums[left]
                curr += 1
                left += 1
            elif nums[curr] == 2:
                nums[right], nums[curr] = nums[curr], nums[right]
                right -= 1
            else:
                curr += 1