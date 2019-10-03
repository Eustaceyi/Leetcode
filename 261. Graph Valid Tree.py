class Solution:
    '''
    DFS solution
    '''
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if len(edges) != n-1:
            return False
        visited = [False] * n
        graph = {}
        for e in edges:
            graph[e[0]] = graph.get(e[0], []) + [e[1]]
            graph[e[1]] = graph.get(e[1], []) + [e[0]]
        if self.hasCycle(graph, -1, 0, visited):
            return False
        if not all(visited):
            return False
        return True
        
        
    def hasCycle(self, graph, parent, curr, visited):
        if visited[curr]:
            return True
        visited[curr] = True
        for node in graph.get(curr, []):
            if (node != parent):
                if self.hasCycle(graph, curr, node, visited):
                    return True
        return False

class Solution:
    '''
    BFS solution
    '''
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if len(edges) != n-1:
            return False
        visited = [False] * n
        graph = {}
        for e in edges:
            graph[e[0]] = graph.get(e[0], []) + [e[1]]
            graph[e[1]] = graph.get(e[1], []) + [e[0]]
        queue = [0]
        while queue:
            item = queue.pop(0)
            if visited[item]:
                continue
            visited[item] = True
            for i in graph.get(item, []):
                queue.append(i)
        if not all(visited):
            return False
        return True

class UF:
    def __init__(self, N):
        self.ids = [i for i in range(N)]
        
    def root(self, A):
        while A != self.ids[A]:
            self.ids[A] = self.ids[self.ids[A]]
            A = self.ids[A]
        return A
    
    def union(self, A, B):
        i = self.root(A)
        j = self.root(B)
        self.ids[i] = j

class Solution:
    '''
    UF solution
    '''
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if len(edges) != n-1:
            return False
        uf = UF(n)
        for e1, e2 in edges:
            r1 = uf.root(e1)
            r2 = uf.root(e2)
            
            if r1 == r2: # if they are already connected before adding this edge, then after adding this, there must be circle in the graph
                return False
            
            uf.union(e1, e2)
        return True