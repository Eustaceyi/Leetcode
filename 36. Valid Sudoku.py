class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        '''
        this is a one pass check, key point is build a hashmap to store values that checked before
        the trick of the blocks is mark blocks as 0-8 and access them by (i//3)*3+j//3
        '''
        block = [{} for i in range(9)]
        row = [{} for i in range(9)]
        column = [{} for i in range(9)]
        for i in range(9):
            for j in range(9):
                if board[i][j].isdigit():
                    if board[i][j] in row[i] or board[i][j] in column[j] or board[i][j] in block[(i//3)*3+j//3]:
                        return False
                    else:
                        row[i][board[i][j]] = 1
                        column[j][board[i][j]] = 1
                        block[(i//3)*3+j//3][board[i][j]] = 1
        return True