class TrieNode:
    def __init__(self):
        self.child = {}
        self.isEndofWord = False

class WordDictionary:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        """
        Adds a word into the data structure.
        """
        node = self.root
        length = len(word)
        for level in range(length):
            pos = word[level]
            if pos not in node.child:
                node.child[pos] = TrieNode()
            node = node.child[pos]
        node.isEndofWord = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
        """
        self.ret = False
        self.dfs(word, self.root)
        return self.ret
        
    def dfs(self, word, node):
        if not word:
            if node.isEndofWord:
                self.ret = True
            return
        
        if word[0] == '.':
            for i in node.child:
                self.dfs(word[1:], node.child[i])
        else:
            if word[0] in node.child:
                self.dfs(word[1:], node.child[word[0]])
            else:
                return

# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)