class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        if not nums:
            return 0
        if val not in nums:
            return len(nums)
        read, write = 0, 0
        while read < len(nums):
            nums[write] = nums[read]
            if nums[read] == val:
                write -= 1
            read += 1
            write += 1
        return write

class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        if not nums:
            return 0
        if val not in nums:
            return len(nums)
        count = 0
        for i in range(len(nums)):
            if nums[i] != val:
                nums[count] = nums[i]
                count += 1
        return count