class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        if len(nums) == 1:
            if nums[0] == target:
                return 0
            else:
                return -1
        pivot = self.findpivot(nums)
        if pivot == 0:
            return self.partsearch(nums, target, 0)
        if target >= nums[0]:
            return self.partsearch(nums[0:pivot], target, 0)
        else:
            return self.partsearch(nums[pivot:len(nums)], target, pivot)
        
    def findpivot(self, nums):
        start, end = 0, len(nums)-1
        if nums[start] < nums[end]:
            return 0
        while start <= end:
            mid = (end - start)//2 + start
            if nums[mid] > nums[mid+1]:
                return mid + 1
            else:
                if nums[mid] < nums[start]:
                    end = mid - 1
                else:
                    start = mid + 1
    
    def partsearch(self, nums, target, pivot):
        if target < nums[0] or target > nums[-1]:
            return -1
        start, end = 0, len(nums)-1
        while start <= end:
            mid = (end - start)//2 + start
            if nums[mid] == target:
                return mid + pivot
            elif nums[mid] > target:
                end = mid - 1
            else:
                start = mid + 1
        return -1