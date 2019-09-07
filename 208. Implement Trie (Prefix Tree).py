class TrieNode:
    def __init__(self):
        self.child = {}
        self.isEndofWord = False

class Trie:
    '''
    https://www.geeksforgeeks.org/trie-insert-and-search/
    Replace the list with dictionary
    '''
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
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
        Returns if the word is in the trie.
        """
        node = self.root
        length = len(word)
        for level in range(length):
            pos = word[level]
            if pos not in node.child:
                return False
            node = node.child[pos]
        if node.isEndofWord:
            return True
        else:
            return False

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        node = self.root
        length = len(prefix)
        for level in range(length):
            pos = prefix[level]
            if pos not in node.child:
                return False
            node = node.child[pos]
        return True

        
        
# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)