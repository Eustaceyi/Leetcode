class Solution:
    def threeSumSmaller(self, nums: List[int], target: int) -> int:
        nums.sort()
        count = 0
        for i in range(len(nums)):
            newtar = target - nums[i]
            lo, hi = i+1, len(nums)-1
            while lo < hi:
                if nums[lo] + nums[hi] >= newtar:
                    hi-=1
                else:
                    count+=hi-lo
                    lo+=1
        return count