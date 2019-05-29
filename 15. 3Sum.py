class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        '''
        This uses two pointer and checks dups when appending new things into lists.
        '''
        if len(nums) < 3:
            return []
        elif len(nums) == 3 and sum(nums) == 0:
            return [nums]
        elif len(nums) == 3 and sum(nums) != 0:
            return []
        nums.sort()
        toret = []
        for i in range(len(nums) - 2):
            if nums[i] > 0:
                break
            if i > 0 and nums[i] == nums[i-1]:
                continue
            l, r = i+1, len(nums) - 1
            while l < r:
                s = nums[i] + nums[l] + nums[r]
                if s > 0:
                    r -= 1
                if s < 0:
                    l += 1
                if s == 0:
                    toret.append([nums[i], nums[l], nums[r]])
                    while l < r and nums[l+1] == nums[l]:
                        l += 1
                    while r > l and nums[r-1] == nums[r]:
                        r -= 1
                    l += 1
                    r -= 1
        return toret

class AnotherSolution:
    '''
    This is the fastest solution, maybe come back later
    '''
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        ans = []
        numcounts = self.count(nums)    # get set(nums) and their counts
        nums = sorted(numcounts)        # same as set(nums)
        for i, num in enumerate(nums):
            '''
                We consider two scenarios:
                    When there are duplicate nums in a solution
                    When all values in a solution are unique
                        at which point, we perform twosum for each negative num
            '''
            # there are 2 scenarios for 2 duplicate vals
            if numcounts[num] >= 2:       
                if num == 0:              # zeros
                    if numcounts[num] >= 3:
                        ans.append([0, 0, 0])
                else:                     # and non-zeros
                    if (-2 * num) in nums:
                        ans.append([num, num, -2*num])
            if num < 0:
                ans = self.twosum(ans, nums, numcounts, num, i)

        return ans

    def twosum(self, ans: List[List[int]], nums: List[int], numcounts, num: int, i: int):
        """Find two numbers a, b such that a + b + num = 0 (a + b = -num)"""
        # find 2 nums that sum up to this positive num
        twosum = -num           
        left = bisect.bisect_left(nums, (twosum-nums[-1]), i+1)     # minval
        right = bisect.bisect_right(nums, (twosum//2), left)        # maxval
        
        # we do this knowing the list is sorted
        for num2 in nums[left:right]:   
            num3 = twosum - num2
            if num3 in numcounts and num3 != num2:
                ans.append([num, num2, num3])

        return ans

    def count(self, nums: List[int]):
        """Organize nums by `{num: occurence_count}`"""
        count = {}
        for num in nums:
            if num in count:
                count[num] += 1
            else:
                count[num] = 1
        return count