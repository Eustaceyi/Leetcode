class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        results = []
        self.helper(candidates, target, [], results)
        return results
        
    def helper(self, candidates, target, ls, results):
        if target < candidates[0]:
            return
        for i, can in enumerate(candidates):
            if target == can:
                results.append(ls+[can])
                return
            self.helper(candidates[i:], target-can, ls+[can], results)