class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        if n == 1:
            return [0]
        graph = collections.defaultdict(list)
        for e in edges:
            graph[e[0]].append(e[1])
            graph[e[1]].append(e[0])
        
        leaves = [i for i in graph if len(graph[i])==1]
        
        while n > 2:
            n -= len(leaves)
            newlef = []
            for l in leaves:
                j = graph[l].pop()
                graph[j].remove(l)
                if len(graph[j]) == 1:
                    newlef.append(j)
            leaves = newlef
        return leaves