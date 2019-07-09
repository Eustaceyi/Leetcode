class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        ans = []
        stack = []
        x = 1
        while True:
            l = len(stack)
            if l == k:
                ans.append(stack[:])
            if l == k or x > n - k + l + 1:
                if not stack:
                    return ans
                x = stack.pop() + 1
            else:
                stack.append(x)
                x += 1

class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        results = []
        self.helper(1, n, k, [], results)
        return results
        
    def helper(self, lo, hi, k, result, results):
        if k == 1:
            for i in range(lo, hi+1):
                results.append(result+[i])
            return
        for i in range(lo, hi+1):
            self.helper(i+1, hi, k-1, result+[i], results)