class Solution:
    def maximumProduct(self, nums: List[int]) -> int:
        max1 = -2000
        max2 = -2000
        max3 = -2000
        min1 = 2000
        min2 = 2000
        for num in nums:
            if num > max3:
                max3 = num
                if num > max2:
                    max2, max3 = num, max2
                    if num > max1:
                        max1, max2 = num, max1
            if num < min2:
                min2 = num
                if num < min1:
                    min1, min2 = num, min1
        if max1 < 0:
            return max1*max2*max3
        else:
            if min1*min2 > max2*max3:
                return max1*min1*min2
            else:
                return max1*max2*max3