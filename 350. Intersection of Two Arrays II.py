class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        dic1 = {}
        for i in nums1:
            dic1[i] = dic1.get(i, 0) + 1
        dic2 = {}
        for i in nums2:
            dic2[i] = dic2.get(i, 0) + 1
        
        if len(dic1) > len(dic2):
            dic1, dic2 = dic2, dic1
        
        res = []
        for i in dic1:
            if i in dic2:
                res += [i] * min(dic1[i], dic2[i])
                
        return res