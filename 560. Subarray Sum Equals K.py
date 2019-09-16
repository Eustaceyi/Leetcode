class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        '''
        https://leetcode.com/articles/subarray-sum-equals-k/
        Also approach 2,3 are also good but will TLE on leetcode
        '''
        sum = 0
        count = 0
        dic = {}
        dic[0] = 1
        for num in nums:
            sum += num
            if sum-k in dic:
                count += dic[sum-k]
            dic[sum] = dic.get(sum, 0) + 1
        return count