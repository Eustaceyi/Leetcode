class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        '''
        Use stack to keep track of next larger element
        use dictionary to record pair
        Time O(m+n)
        Space O(m)
        '''
        stack = []
        dic = {}
        for num in nums2:
            while stack and stack[-1] <= num:
                temp = stack.pop()
                dic[temp] = num
            stack.append(num)
        res = []
        for num in nums1:
            res.append(dic.get(num, -1))
        return res