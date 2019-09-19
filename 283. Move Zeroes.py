class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        read = 0
        write = 0
        while write < len(nums):
            if read < len(nums):
                if nums[read]:
                    nums[write] = nums[read]
                    write += 1
                    read += 1
                else:
                    read += 1
            else:
                nums[write] = 0
                write += 1