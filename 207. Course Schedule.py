class Solution:
    '''
    A DFS Solution, time should be O(V*E) space should be O(V*E)
    '''
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        self.graph = [[] for _ in range(numCourses)]
        self.visited = [0 for _ in range(numCourses)]
        for c, p in prerequisites:
            self.graph[c].append(p)
            
        for c in range(numCourses):
            if not self.dfs(c):
                return False
            
        return True
    
    def dfs(self, v):
        if self.visited[v] == -1:
            return False
        if self.visited[v] == 1:
            return True
        self.visited[v] = -1
        for c in self.graph[v]:
            if not self.dfs(c):
                return False
        self.visited[v] = 1
        return True

class Solution:
    '''
    Topolgical Sort, time should be O(V*E) space should be O(V*E)
    '''
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        outde = {i:[] for i in range(numCourses)}
        inde = {i:0 for i in range(numCourses)}
        
        for c, p in prerequisites:
            outde[c].append(p)
            inde[p] += 1
            
        visited = set()
        queue = [n for n in inde if inde[n] == 0]
        
        while queue:
            n = queue.pop(0)
            visited.add(n)
            for v in outde[n]:
                inde[v] -= 1
                if inde[v] == 0:
                    queue.append(v)
                    
        return len(visited) == numCourses