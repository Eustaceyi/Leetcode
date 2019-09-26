class Solution:
    def numWays(self, n: int, k: int) -> int:
        '''
        Thought is like followings:
        1. if prev is as same color as prev of prev:
            then we cannot choose that color (k-1 choice)
        2. if prev is a diff color as prev of prev:
            then we:
                1. choose the same as prev
                2. choose diff color
        
        So we keep two vars:
            same: number of prev is as prev of prev
            diff: number of prev is diff as prev of prev

        Update rule:
            same = prev_diff
            diff = prev_same * (k-1) + prev_diff * (k-1)

        Time O(n)
        Space O(1)
        '''
        if n == 0:
            return 0
        if n == 1:
            return k
        same = 0
        diff = k
        p = 1
        while p < n:
            same, diff = diff * 1, diff * (k-1) + same * (k-1)
            p += 1
        return same+diff