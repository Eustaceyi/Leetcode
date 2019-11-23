class WordDictionary {
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
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode curr = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, 0, root);
    }
    
    private boolean search(String word, int pos, TrieNode node) {
        if (pos == word.length()) {
            return node.isEnd? true : false;
        }
        char c = word.charAt(pos);
        boolean res = false;
        if (c == '.') {
            for (TrieNode next : node.children) {
                if (next != null) {
                    res = res || search(word, pos+1, next);
                }
            }
        } else {
            if (node.children[c-'a'] == null) {
                res = false;
            } else {
                res = search(word, pos+1, node.children[c-'a']);
            }
        }
        return res;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */