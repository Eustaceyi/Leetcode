class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        '''
        HashSet lookup O(1)
        Time O(m+n)
        Space O(m+n)
        '''
        n1 = set(nums1)
        n2 = set(nums2)
        res = set()
        if len(n1) > len(n2):
            n1, n2 = n2, n1
        for i in n1:
            if i in n2:
                res.add(i)
        return res

'''
Follow up, if the arrays are sorted, we can use two-pointers to iter them.
'''
def intersection2(nums1: List[int], nums2: List[int]) -> List[int]:
    nums1.sort()
    nums2.sort()

    res = []

    left, right = 0, 0
    while left < len(nums1) and right < len(nums2):
        left_val = nums1[left]
        right_val = nums2[right]

        if right_val == left_val:
            res.append(nums2[right])
            while right < len(nums2) and nums2[right] == right_val:
                right += 1
            while left < len(nums1) and nums1[left] == left_val:
                left += 1
        if right_val > left_val:
            while left < len(nums1) and left_val == nums1[left]:
                left += 1
        else:
            while right < len(nums2) and right_val == nums2[right]:
                right += 1
    return res