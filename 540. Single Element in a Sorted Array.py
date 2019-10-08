class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        lo, hi = 0, len(nums)-1
        while lo <= hi:
            if lo == hi:
                return nums[lo]
            mid = (hi-lo)//2+lo
            if mid%2 == 0:
                if mid+1 == len(nums):
                    return nums[mid]
                else:
                    if nums[mid] == nums[mid+1]:
                        lo = mid+2
                    else:
                        hi = mid
            else:
                if nums[mid] == nums[mid-1]:
                    lo = mid+1
                else:
                    hi = mid-1