class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        dic = collections.defaultdict(int)
        n = len(nums)
        ls = set()
        for num in nums:
            dic[num] += 1
            if dic[num] > n//3:
                ls.add(num)
        return ls