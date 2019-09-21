class Solution:
    def totalFruit(self, tree: List[int]) -> int:
        result = 0
        f1, f2, f1count, f2count, f2concount = None, None, 0, 0, 0
        for fruit in tree:
            if fruit == f1:
                f1, f2, f1count, f2count, f2concount = f2, f1, f2count+f2concount, f1count, 1
            elif fruit == f2:
                f2concount += 1
            else:
                f1, f2, f1count, f2count, f2concount = f2, fruit, f2concount, 0, 1
            result = max(result, f1count+f2count+f2concount)
        return result