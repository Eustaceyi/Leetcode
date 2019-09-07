class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        outde = {}
        inde = [0] * numCourses
        for c, p in prerequisites:
            if p not in outde:
                outde[p] = [c]
            else:
                outde[p].append(c)
            inde[c] += 1
        queue = [i for i in range(len(inde)) if inde[i] == 0]
        result = []
        while queue:
            node = queue.pop(0)
            result.append(node)
            if node in outde:
                for c in outde[node]:
                    inde[c] -= 1
                    if inde[c] == 0:
                        queue.append(c)
                        
        if len(result) == numCourses:
            return list(result)
        else:
            return []