class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        if len(nums) == 0:
            return []
        if len(nums) == 1:
            return [str(nums[0])]
        arrow = '->'
        inrange = False
        rangestart = None
        result = []
        for i, num in enumerate(nums):
            if inrange:
                if i == len(nums)-1:
                    result.append(str(rangestart) + arrow + str(num))
                else:
                    if nums[i+1] == num + 1:
                        inrange = True
                    else:
                        inrange = False
                        result.append(str(rangestart)+arrow+str(num))
            else:
                if i == len(nums)-1:
                    result.append(str(num))
                else:
                    if nums[i+1] == num + 1:
                        inrange = True
                        rangestart = num
                    else:
                        result.append(str(num))
        return result