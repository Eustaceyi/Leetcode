/**
 * BFS solution, slow but work
 */
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return new ArrayList<>();
        }
        wordSet.add(beginWord);
        int wordLen = beginWord.length();
        HashMap<String, List<String>> wordMap = buildMap(wordSet, wordLen);
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<List<String>>> level = new HashMap<>();
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);
        List<List<String>> toadd = new ArrayList<>();
        toadd.add(temp);
        level.put(beginWord, toadd);
        while (level.size()!=0) {
            HashMap<String, List<List<String>>> nextLevel = new HashMap<>();
            for (Map.Entry<String, List<List<String>>> entry : level.entrySet()) {
                String currWord = entry.getKey();
                List<List<String>> currpaths = entry.getValue();
                for (List<String> currpath : currpaths) {
                    if (currWord.equals(endWord)) {
                        ans.add(new ArrayList<>(currpath));
                    } else {
                        for (String nextWord : wordMap.get(currWord)) {
                            if (wordSet.contains(nextWord) && !currpath.contains(nextWord)) {
                                currpath.add(nextWord);
                                if (nextLevel.containsKey(nextWord)) {
                                    nextLevel.get(nextWord).add(new ArrayList<>(currpath));
                                } else {
                                    toadd = new ArrayList<>();
                                    toadd.add(new ArrayList<>(currpath));
                                    nextLevel.put(nextWord, toadd);
                                }
                                currpath.remove(currpath.size() - 1);
                            }
                        }
                    }
                }
            }
            for (String word : nextLevel.keySet()) {
                wordSet.remove(word);
            }
            if (ans.size()!=0) {
                break;
            }
            level = nextLevel;
        }
        return ans;
    }

    private HashMap<String, List<String>> buildMap (HashSet<String> wordSet, int wordLen) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String word : wordSet) {
            map.put(word, new ArrayList<>());
            for (int i = 0; i < wordLen; i++) {
                for (int j = 0; j < 26; j++) {
                    String nextWord = word.substring(0, i) +
                            Character.toString((char) ('a' + j)) +
                            word.substring(i + 1, wordLen);
                    map.get(word).add(nextWord);
                }
            }
        }
        return map;
    }
}