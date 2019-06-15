class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        results = []
        self.helper(candidates, target, [], results)
        return results
        
    def helper(self, candidates, target, ls, results):
        if not candidates or target < candidates[0]:
            return
        for i, can in enumerate(candidates):
            if target == can:
                results.append(ls+[can])
                return
            if i > 0 and can == candidates[i-1]:
                continue
            self.helper(candidates[i+1:], target-can, ls+[can], results)