from collections import defaultdict

class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: list[str]) -> list[list[str]]:
        wl = set(wordList)
        if endWord not in wl:
            return []
        res = []
        l = len(beginWord)
        layer = {beginWord: [[beginWord]]}
        while layer:
            newlayer = defaultdict(list)
            for item in layer:
                if item == endWord:
                    res.extend(path for path in layer[item])
                else:
                    for c in string.ascii_lowercase:
                        for i in range(l):
                            newword = item[:i] + c + item[i+1:]
                            if newword in wl:
                                newlayer[newword] += [path + [newword] for path in layer[item]]
            layer = newlayer
            wl -= set(newlayer.keys())
            if res:
                break
        return res