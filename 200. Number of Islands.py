class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        '''
        DFS
        '''
        self.count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    self.helper(grid, i, j)
                    self.count += 1
        return self.count
        
    def helper(self, grid, i, j):
        grid[i][j] = '#'
        if i > 0 and grid[i-1][j] == '1':
            self.helper(grid, i-1, j)
        if j > 0 and grid[i][j-1] == '1':
            self.helper(grid, i, j-1)
        if i < len(grid) - 1 and grid[i+1][j] == '1':
            self.helper(grid, i+1, j)
        if j < len(grid[0]) - 1 and grid[i][j+1] == '1':
            self.helper(grid, i, j+1)

    def numIslandsBFS(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if not grid or not grid[0]:
            return 0

        m, n = len(grid), len(grid[0])
        count = 0
        for i in xrange(m):
            for j in xrange(n):
                if grid[i][j] == '1':
                    self.bfs(grid, i, j)
                    count += 1
        return count

    def bfs(self, grid, r, c):
        queue = collections.deque()
        queue.append((r, c))
        grid[r][c] = '0'
        while queue:
            directions = [(0,1), (0,-1), (-1,0), (1,0)]
            r, c = queue.popleft()
            for d in directions:
                nr, nc = r + d[0], c + d[1]    
                if self.is_valid(grid, nr, nc) and grid[nr][nc] == '1':
                    queue.append((nr, nc))
                    grid[nr][nc] = '0'

    def is_valid(self, grid, r, c):
        m, n = len(grid), len(grid[0])
        if r < 0 or c < 0 or r >= m or c >= n:
            return False
        return True

class Solution(object):
    '''
    Union find
    '''
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        if len(grid) == 0: return 0
        row = len(grid); col = len(grid[0])
        self.count = sum(grid[i][j]=='1' for i in range(row) for j in range(col))
        parent = [i for i in range(row*col)]
        
        def find(x):
            if parent[x]!= x:
                return find(parent[x])
            return parent[x]
        
        def union(x,y):
            xroot, yroot = find(x),find(y)
            if xroot == yroot: return 
            parent[xroot] = yroot
            self.count -= 1
        
        
        
        for i in range(row):
            for j in range(col):
                if grid[i][j] == '0':
                    continue
                index = i*col + j
                if j < col-1 and grid[i][j+1] == '1':
                    union(index, index+1)
                if i < row-1 and grid[i+1][j] == '1':
                    union(index, index+col)
        return self.count