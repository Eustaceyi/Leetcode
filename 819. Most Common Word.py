class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        words = re.split("[ !?',;.]+", paragraph)
        dic = collections.defaultdict(int)
        ban = set(banned)
        for word in words:
            word = word.lower()
            if word and word not in ban:
                dic[word] += 1
        maxcount = 0
        most = ""
        for w in dic:
            if dic[w] > maxcount:
                maxcount = dic[w]
                most = w
        return most