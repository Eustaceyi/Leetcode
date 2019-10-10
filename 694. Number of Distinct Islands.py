class Solution:
    def numDistinctIslands(self, grid: List[List[int]]) -> int:
        '''
        record the relative coordinate and put into count
        '''
        seen = set()
        rl, cl = len(grid), len(grid[0])
        def find(r, c, r0, c0):
            if r >= 0 and r < rl and c >= 0 and c < cl and grid[r][c] and (r,c) not in seen:
                shape.add((r-r0, c-c0))
                seen.add((r,c))
                find(r+1, c, r0, c0)
                find(r, c+1, r0, c0)
                find(r-1, c, r0, c0)
                find(r, c-1, r0, c0)
          
        shapes = set()
        for i in range(rl):
            for j in range(cl):
                shape = set()
                find(i, j, i, j)
                if shape:
                    shapes.add(tuple(shape))
        return len(shapes)

class Solution:
    def numDistinctIslands(self, grid: List[List[int]]) -> int:
        '''
        put the path to traverse the island into a set
        '''
        seen = set()
        rl, cl = len(grid), len(grid[0])
        def find(r, c, dir):
            if r >= 0 and r < rl and c >= 0 and c < cl and grid[r][c] and (r,c) not in seen:
                seen.add((r,c))
                nonlocal path
                path += dir
                find(r+1, c, 'D')
                find(r, c+1, 'R')
                find(r-1, c, 'U')
                find(r, c-1, 'L')
                path += dir
          
        shapes = set()
        for i in range(rl):
            for j in range(cl):
                path = ''
                find(i, j, '.')
                if path:
                    shapes.add(path)
        return len(shapes)