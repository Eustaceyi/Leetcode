class Solution:
    '''
    backtracking solution, Time O(n!) Space O(n)
    we start from row 0 and to last row, in these condition, we try each col if it can place a queen and if it can,
    we go to the next row, and we backtrack the result.
    Remember to remove the one we add!
    '''
    def solveNQueens(self, n: int) -> List[List[str]]:
        cols = [0 for i in range(n)]
        major = [0 for i in range(2*n-1)]
        minor = [0 for i in range(2*n-1)]
        queens = set()
        ans = []
        def could_place(row, col):
            return not cols[col] + major[row-col] + minor[col+row]
        
        def place_queen(row, col):
            queens.add((row,col))
            cols[col] = 1
            major[row-col] = 1
            minor[col+row] = 1
            
        def remove_queen(row, col):
            queens.remove((row,col))
            cols[col] = 0
            major[row-col] = 0
            minor[col+row] = 0
            
        def addtoans():
            solution = []
            for _, col in sorted(queens):
                solution.append('.'*col + 'Q' + '.' * (n-col-1))
            ans.append(solution)
            
        def backtracking(row=0):
            for col in range(n):
                if could_place(row, col):
                    place_queen(row, col)
                    if row + 1 == n:
                        addtoans()
                    else:
                        backtracking(row+1)
                    remove_queen(row, col)
                    
        backtracking()
        return ans