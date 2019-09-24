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