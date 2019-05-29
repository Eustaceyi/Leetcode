class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:
        '''
        This also uses two pointers, but add some early exit conditions.
        '''
        if len(nums) < 3:
            return 0
        elif len(nums) == 3:
            return sum(nums)
        nums.sort()
        ret = nums[0] + nums[1] + nums[2]

        for i in range(len(nums)-2):
            # if this is the one we have already checked, we can pass it
            if i > 0 and nums[i-1] == nums[i]:
                continue
            l, r = i+1, len(nums)-1
            # if the largest sum of this iter is smaller than the target, we don't have to loop 
            if nums[i] + nums[r-1] + nums[r] <= target:
                s = nums[i] + nums[r-1] + nums[r]
                if s == target:
                    return s
                if target - s < abs(ret - target):
                    ret = s
            # if the smallest sum of this iter is larger than the target, we don't have to loop 
            elif nums[i] + nums[l] + nums[l+1] >= target:
                s = nums[i] + nums[r-1] + nums[r]
                if s == target:
                    return s
                if s - target < abs(ret - target):
                    ret = s
            # finally we have to loop
            else:
                while l < r:
                    s = nums[i] + nums[l] + nums[r]
                    if s == target:
                        return target
                    if abs(s - target) < abs(ret - target):
                        ret = s
                    if s > target:
                        r -= 1
                    else:
                        l += 1
        return ret