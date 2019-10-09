class TrieNode:
    def __init__(self):
        self.child = {}
        self.isEnd = False
        
class Trie:
    def __init__(self):
        self.root = TrieNode()
        
    def add(self, word):
        l = len(word)
        curr = self.root
        for i in range(l):
            if word[i] not in curr.child:
                curr.child[word[i]] = TrieNode()
            curr = curr.child[word[i]]
        curr.isEnd = True
        return

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        dir = [(1,0), (0,1), (-1,0), (0,-1)]
        # build Trie
        T = Trie()
        for word in words:
            T.add(word)
        res = set()
        
        def check(board, i, j, node, ls):
            if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]):
                return
            c = board[i][j]
            board[i][j] = '#'
            if c in node.child:
                if node.child[c].isEnd:
                    res.add(''.join(ls+[c]))
                for di, dj in dir:
                    check(board, i+di, j+dj, node.child[c], ls + [c])
            board[i][j] = c
            
        if not board:
            return res
        for i in range(len(board)):
            for j in range(len(board[0])):
                check(board, i, j, T.root, [])
        return res