class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        results = []
        self.dfs(1, n, k, [], results)
        return results
        
        
    def dfs(self, start, dest, numleft, result, results):
        if dest == 0 and numleft == 0:
            results.append(result)
            return
        if dest != 0 and numleft <= 0:
            return
        for i in range(start,10):
            self.dfs(i+1, dest-i, numleft-1, result+[i], results)