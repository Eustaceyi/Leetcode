class Solution:
    def maxSumTwoNoOverlap(self, A: List[int], L: int, M: int) -> int:
        '''
        O(n) / O(n) solution
        '''
        # build the presum array
        n = len(A)
        if L+M > n:
            return 0
        presum = [0 for i in range(n)]
        presum[0] = A[0]
        for i in range(1, n):
            presum[i] = presum[i-1] + A[i]
        # start from L+M
        res, Lmax, Mmax = presum[L + M - 1], presum[L - 1], presum[M - 1]
        for i in range(L + M, n):
            Lmax = max(Lmax, presum[i - M] - presum[i - L - M]) # finding the max of curr seen L
            Mmax = max(Mmax, presum[i - L] - presum[i - L - M]) # finding the max of curr seen M
            res = max(res, Lmax + presum[i] - presum[i - M], Mmax + presum[i] - presum[i - L]) # comparing currmax and L,M max and M,L max
        return res


class Solution:
    def maxSumTwoNoOverlap(self, A: List[int], L: int, M: int) -> int:
        '''
        My O(n^2) solution, easy to come up with
        '''
        n = len(A)
        if L+M > n:
            return 0
        presum = [0 for i in range(n+1)]
        for i in range(n):
            presum[i+1] = presum[i] + A[i]
        
        maxtotal = 0
        for i in range(n-L+1):
            sumL = presum[i+L] - presum[i]
            maxM = 0
            for j in range(0, i-M+1):
                maxM = max(maxM, presum[j+M]-presum[j])
            for j in range(i+L, n-M+1):
                maxM = max(maxM, presum[j+M]-presum[j])
            maxtotal = max(maxtotal, sumL+maxM)
        return maxtotal