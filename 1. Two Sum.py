class Solution:
    def twoSum(self, nums, target):
        dict = {}
        for i, num in enumerate(nums):
            if num in dict:
                return [i, dict[num]]
            dict[target - num] = i
        return