class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        '''
        https://leetcode.com/articles/find-the-duplicate-number/
        Approach 3: fast slow pointer
        Time O(n)
        Space O(1)
        '''
        fast, slow = nums[0], nums[0]
        while 1:
            fast = nums[nums[fast]]
            slow = nums[slow]
            if fast == slow:
                break
        
        p1 = nums[0]
        p2 = slow
        while p1 != p2:
            p1 = nums[p1]
            p2 = nums[p2]
        return p1