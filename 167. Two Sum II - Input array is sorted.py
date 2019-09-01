class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        l, r = 0, len(numbers)-1
        while l < r:
            if numbers[l] + numbers[r] ==  target:
                return [l+1, r+1]
            if numbers[l] + numbers[r] > target:
                while r > 0 and numbers[r-1] == numbers[r]:
                    r -= 1
                r -= 1
            else:
                while l < len(numbers)-1 and numbers[l] == numbers[l+1]:
                    l += 1
                l += 1