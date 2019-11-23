class Trie {
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        public TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
        }
    }

    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (int i=0; i<word.length(); i++) {
            char currchar = word.charAt(i);
            if (curr.children[currchar-'a'] == null) {
                curr.children[currchar-'a'] = new TrieNode();
            }
            curr = curr.children[currchar-'a'];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i=0; i<word.length(); i++) {
            char currchar = word.charAt(i);
            if (curr.children[currchar-'a'] == null) {
                return false;
            }
            curr = curr.children[currchar-'a'];
        }
        if (!curr.isEnd) {
            return false;
        }
        return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i=0; i<prefix.length(); i++) {
            char currchar = prefix.charAt(i);
            if (curr.children[currchar-'a'] == null) {
                return false;
            }
            curr = curr.children[currchar-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */