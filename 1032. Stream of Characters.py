class TrieNode:
    def __init__(self):
        self.child = [None] * 26
        self.isend = False

class Trie:
    def __init__(self):
        self.root = None
    
    def add(self, word):
        if not self.root:
            self.root = TrieNode()
        p = self.root
        for c in word:
            if not p.child[ord(c)-ord('a')]:
                p.child[ord(c)-ord('a')] = TrieNode()
            p = p.child[ord(c)-ord('a')]
        p.isend = True
        

class StreamChecker:
    '''
    Thinking:
    1. build reverse trie to make it easy to traverse with stream
    2. keep a truncated stream of max word len to store all possible situations
    3. check each letter whether the reversed stream in trie, if one of them in trie, return True else return Flase
    '''
    def __init__(self, words: List[str]):
        self.n = max([len(w) for w in words])
        self.T = Trie()
        for w in words:
            self.T.add(w[::-1])
        self.s = []

    def query(self, letter: str) -> bool:
        self.s.append(letter)
        if len(self.s) > self.n:
            self.s.pop(0)
        node = self.T.root
        for c in self.s[::-1]:
            node = node.child[ord(c)-ord('a')]
            if not node:
                return False
            if node and node.isend:
                return True
        return False
        
        
# Your StreamChecker object will be instantiated and called as such:
# obj = StreamChecker(words)
# param_1 = obj.query(letter)