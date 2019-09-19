class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        '''
        dict + heapq, time O(nlogk) space O(n)
        '''
        dic = {}
        for num in nums:
            dic[num] = dic.get(num, 0) + 1
        setnums = set(nums)
        result = []
        for num in setnums:
            if len(result) < k:
                heapq.heappush(result, (dic[num], num))
            else:
                if dic[num] > dic[result[0][1]]:
                    heapq.heappop(result)
                    heapq.heappush(result, (dic[num], num))
        return [item[1] for item in result[::-1]]

class Solution:
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """ 
        count = collections.Counter(nums)   
        return heapq.nlargest(k, count.keys(), key=count.get) 