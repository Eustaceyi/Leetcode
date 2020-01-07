/**
 * Use treemap for keeping order and finding the prefix of words and pick up 3 words
 */
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        TreeMap<String, Integer> map = new TreeMap<>();
        Arrays.sort(products);
        for (int i=0; i<products.length; i++) {
            map.put(products[i], i);
        }
        String pre = "";
        for (char c : searchWord.toCharArray()) {
            pre += c;
            String ceil = map.ceilingKey(pre);
            String floor = map.floorKey(pre+'~');
            if (ceil==null || floor==null) {
                break;
            }
            int start = map.get(ceil);
            int end = Math.min(map.get(floor)+1, start+3);
            List<String> toadd = new ArrayList<>();
            for (int i=start; i<end; i++) {
                toadd.add(products[i]);
            }
            ans.add(toadd);
        }
        for (int i=ans.size(); i<searchWord.length(); i++) {
            ans.add(new ArrayList<>());
        }
        return ans;
    }
}

/**
 * Trie Solution
 */
class Solution {
    class TrieNode {
        TrieNode[] child;
        boolean isEnd;
        public TrieNode() {
            child = new TrieNode[26];
            isEnd = false;
        }
    }
    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        public void add(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.child[c-'a'] == null) {
                    node.child[c-'a'] = new TrieNode();
                }
                node = node.child[c-'a'];
            }
            node.isEnd = true;
        }
        public List<String> startWith(List<Character> chars) {
            List<String> ans = new ArrayList<>();
            TrieNode node = root;
            for (char c : chars) {
                if (node.child[c-'a'] == null) {
                    return ans;
                }
                node = node.child[c-'a'];
            }
            StringBuilder sb = new StringBuilder();
            for (char c : chars) {
                sb.append(c);
            }
            if (node.isEnd) {
                ans.add(sb.toString());
            }
            backtrack(node, ans, sb);
            return ans;
        }
        private void backtrack(TrieNode node, List<String> ans, StringBuilder sb) {
            if (ans.size() == 3) {return;}
            for (int i=0; i<26; i++) {
                if (ans.size() == 3) {return;}
                TrieNode next = node.child[i];
                if (next == null) {
                    continue;
                }
                sb.append((char)(i+'a'));
                if (next.isEnd) {
                    ans.add(sb.toString());
                    if (ans.size() == 3) {return;}
                }
                backtrack(next, ans, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie t = new Trie();
        for (String product : products) {
            t.add(product);
        }
        List<List<String>> ans = new ArrayList<>();
        List<Character> chars = new ArrayList<>();
        for (char c : searchWord.toCharArray()) {
            chars.add(c);
            ans.add(t.startWith(chars));
        }
        return ans;
    }
}