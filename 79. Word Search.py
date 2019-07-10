class Solution:
    '''
    A dfs solution with precheck for word in board
    '''
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not board:
            return False
        if not self.precheck(board, word):
            return False
        for i in range(len(board)):
            for j in range(len(board[0])):
                if self.check(board, i, j, word):
                    return True
        return False
                
    def check(self, board, i, j, word):
        if not word:
            return True
        
        if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]):
            return False
        
        if board[i][j] == word[0]:
            temp = board[i][j]
            board[i][j] = '#'

            res = self.check(board, i+1, j, word[1:]) or \
                  self.check(board, i-1, j, word[1:]) or \
                  self.check(board, i, j+1, word[1:]) or \
                  self.check(board, i, j-1, word[1:])
            
            board[i][j] = temp
            
            return res
        else:
            return False
        
    def precheck(self, board, word):
        dic = {}
        for char in word:
            if char in dic:
                dic[char] += 1
            else:
                dic[char] = 1
                
        for line in board:
            for char in line:
                if char in dic:
                    dic[char] -= 1
        for char in dic:
            if dic[char] > 0:
                return False
        return True