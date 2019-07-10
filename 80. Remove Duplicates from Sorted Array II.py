class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        '''
        original two-pointer version
        '''
        if not nums or len(nums) <= 2:
            return len(nums)
        read = write = 1
        count = 1
        while read < len(nums):
            if nums[read] == nums[read-1]:
                if count < 2:
                    count += 1
                    nums[write] = nums[read]
                    write += 1
                elif count >= 2:
                    count += 1
            else:
                count = 1
                nums[write] = nums[read]
                write += 1
            read += 1
        return write

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        '''
        a more shorter version
        '''
        i = 0
        for n in nums:
            if i < 2 or n > nums[i-2]:
                nums[i] = n
                i += 1
        return i