class TrieNode {
    boolean isEnd;
    TrieNode[] child;
    public TrieNode() {
        isEnd = false;
        child = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    void add(String word) {
        TrieNode curr = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (curr.child[c-'a'] == null) {
                curr.child[c-'a'] = new TrieNode();
            }
            curr = curr.child[c-'a'];
        }
        curr.isEnd = true;
    }
}

class Solution {
    char[][] board;
    int row, col;
    Trie t;
    int maxlen;
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length==0 || board[0].length==0 || words==null || words.length==0) {
            return new ArrayList<>();
        }
        this.board = board;
        row = board.length;
        col = board[0].length;
        t = new Trie();
        maxlen = 0;
        HashSet<String> ans = new HashSet<>();
        for (String word : words) {
            t.add(word);
            maxlen = Math.max(word.length(), maxlen);
        }
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                check(i, j, new StringBuilder(), t.root, ans);
            }
        }
        return new ArrayList<>(ans);
    }
    private void check(int i, int j, StringBuilder sb, TrieNode curr, HashSet<String> ans) {
        if (sb.length() > maxlen) {
            return;
        }
        if (board[i][j] != '#' && curr.child[board[i][j]-'a']!=null) {
            sb.append(board[i][j]);
            if (curr.child[board[i][j]-'a'].isEnd) {
                ans.add(sb.toString());
            }
            char letter = board[i][j];
            board[i][j] = '#';
            if (i>0 && board[i-1][j] != '#') {
                check(i-1, j, sb, curr.child[letter-'a'], ans);
            }
            if (i<row-1 && board[i+1][j] != '#') {
                check(i+1, j, sb, curr.child[letter-'a'], ans);
            }
            if (j>0 && board[i][j-1] != '#') {
                check(i, j-1, sb, curr.child[letter-'a'], ans);
            }
            if (j<col-1 && board[i][j+1] != '#') {
                check(i, j+1, sb, curr.child[letter-'a'], ans);
            }
            sb.deleteCharAt(sb.length()-1);
            board[i][j] = letter;
        }
    }
}