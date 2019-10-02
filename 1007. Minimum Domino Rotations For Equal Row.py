class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        '''
        Two pass, the solution should all be A[0] or B[0] or -1,
        so we check if A[0] works, if A[0] does not work, we try B[0]
        if A[0] == B[0], we also don't need to check B[0].
        When A[0] work, why we don't need to check B[0] is because that:
        1. B[0] may not work due to left parts are different
        2. B[0] will also work but the change will be the same as A[0]
        So we don't need to check B[0] when A[0] work
        Time O(n)
        Space O(1)
        '''
        n = len(A)
        
        def check(x):
            flip_a = flip_b = 0
            for i in range(n):
                if A[i] != x and B[i] != x:
                    return -1
                elif A[i] != x:
                    flip_a += 1
                elif B[i] != x:
                    flip_b += 1
            return min(flip_a, flip_b)
        
        rot = check(A[0])
        if rot != -1 or A[0] == B[0]:
            return rot
        else:
            return check(B[0])

class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        '''
        Use first pass to count all elements, and try 1~6 one by one
        Time O(n)
        Space O(1) constant space since we only need 3 * Array of size 6
        '''
        up = [0] * 6
        down = [0] * 6
        same = [0] * 6
        for i in range(len(A)):
            up[A[i]-1] += 1
            down[B[i]-1] += 1
            if A[i] == B[i]:
                same[A[i]-1] += 1
                
        for i in range(6):
            if up[i] + down[i] - same[i] >= len(A):
                return len(A) - max(up[i], down[i])
        return -1