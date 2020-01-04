/**
 * No reverse solution
 */
class StreamChecker {
    public class TrieNode {
        TrieNode[] child;
        boolean isEnd;
        TrieNode() {
            child = new TrieNode[26];
            isEnd = false;
        }
    }
    
    TrieNode root;
    Queue<TrieNode> q;
    
    void add(String word) {
        int len = word.length();
        TrieNode n = root;
        for (int i=0; i<len; i++) {
            char c = word.charAt(i);
            if (n.child[c-'a'] == null) {
                n.child[c-'a'] = new TrieNode();
            } 
            n = n.child[c-'a'];
        }
        n.isEnd = true;
    }

    public StreamChecker(String[] words) {
        root = new TrieNode();
        q = new ArrayDeque<>();
        for (String word : words) {
            add(word);
        }
        q.offer(root);
    }
    
    public boolean query(char letter) {
        int len = q.size();
        boolean res = false;
        for (int i=0; i<len; i++) {
            TrieNode n = q.poll();
            if (n.child[letter-'a'] != null) {
                q.offer(n.child[letter-'a']);
                if (n.child[letter-'a'].isEnd) {
                    res = true;
                }
            }
        }
        q.offer(root);
        return res;
    }
}

class StreamChecker {
    
    class TrieNode {
        boolean isWord;
        TrieNode[] next = new TrieNode[26];
    }

    TrieNode root = new TrieNode();
    StringBuilder sb = new StringBuilder();

    public StreamChecker(String[] words) {
        createTrie(words);
    }

    public boolean query(char letter) {
        sb.append(letter);
        TrieNode node = root;
        for (int i = sb.length() - 1; i >= 0 && node != null; i--) {
            char c = sb.charAt(i);
            node = node.next[c - 'a'];
            if (node != null && node.isWord) {
                return true;
            }
        }
        return false;
    }

    private void createTrie(String[] words) {
        for (String s : words) {
            TrieNode node = root;
            int len = s.length();
            for (int i = len - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (node.next[c - 'a'] == null) {
                    node.next[c - 'a'] = new TrieNode();
                }
                node = node.next[c - 'a'];
            }
            node.isWord = true;
        }
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */