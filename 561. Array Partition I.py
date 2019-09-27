class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        return sum(sorted(nums)[::2])

class Solution(object):
    def arrayPairSum(self, nums):
        """
        We use the same idea to pair adjacent elements, but instead use a counting sort approach.
        Range of numbers is -10k to 10k. This means 20001 elements.
        Build the frequency map for the input.
        Now iterate this map. When frequency is even, the contribution is the implied number times freq//2. When odd, it is (implied number) times (freq//2 + 1).
        Implied number: (idx-10000)
        The time and space complexity is order K where K is the range of the numbers.
        """
        res = [0]*20001
        for x in nums:
            res[x+10000] += 1
        s_so_far, adjust = 0, False
        for idx, freq in enumerate(res):
            if freq:
                freq = freq-1 if adjust else freq
                if freq&1:
                    s_so_far += ((freq//2) + 1)*(idx-10000)
                    adjust = True
                else:
                    s_so_far += ((freq//2))*(idx-10000)
                    adjust = False
        return s_so_far