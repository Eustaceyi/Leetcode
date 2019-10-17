class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        '''
        Hashset solution
        Time O(n) two pass: one for building the set, one for checking the numbers
        Space O(n) for hashset
        '''
        s = set(nums)
        for i in range(len(s)+1):
            if i not in s:
                return i

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        '''
        bit manipulation solution, we are using that:
        a^a^b^b^c = c
        in this situation
        the index is from 0 ~ (n-1)
        and the number is missing one from 0 ~ n
        so we first introduce a n into the total XOR
        and we can easily find out the solution
        '''
        n = len(nums)
        for i, num in enumerate(nums):
            n = num^n^i
        return n

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        '''
        the sum from 0 to n is n*(n+1)/2
        by subtracting the sum of nums we will know the missing number
        '''
        n = len(nums)
        return int(n * (n+1) / 2) - sum(nums)