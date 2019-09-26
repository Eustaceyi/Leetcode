class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        '''
        Thought:
        Each 1 will have 4 edges, if there are 1 on the right or the down, 
        will reduce 2 edges.
        Since we are going from left to right, and from top to down,
        so we don't need to check left and top.
        Time O(rc)
        Space O(1) 
        '''
        island = 0
        neighbor = 0
        r, c = len(grid), len(grid[0])
        for i in range(r):
            for j in range(c):
                if grid[i][j] == 1:
                    island += 1
                    if i< r-1 and grid[i+1][j] == 1:
                        neighbor += 1
                    if j < c-1 and grid[i][j+1] == 1:
                        neighbor += 1
        return 4*island - 2 *neighbor