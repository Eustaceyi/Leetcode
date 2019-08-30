class Solution:
    def findMissingRanges(self, nums: List[int], lower: int, upper: int) -> List[str]:
        output = []
        if not nums:
            if lower < upper:
                output.append(str(lower)+'->'+str(upper))
            else:
                output.append(str(lower))
            return output
        if lower != nums[0]:
            if lower < nums[0]-1:
                output.append(str(lower) + '->' + str(nums[0]-1))
            else:
                output.append(str(lower))
        for i in range(len(nums)-1):
            if nums[i+1] - nums[i] > 2:
                output.append(str(nums[i]+1)+'->'+str(nums[i+1]-1))
            elif nums[i+1] == nums[i] or nums[i+1] - nums[i] == 1:
                continue
            else:
                output.append(str(nums[i]+1))
        if upper != nums[-1]:
            if upper > nums[-1]+1:
                output.append(str(nums[-1]+1)+'->'+str(upper))
            else:
                output.append(str(upper))
        return output