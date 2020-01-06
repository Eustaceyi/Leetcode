class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(s) < len(p):
            return []
        pcount = [0] * 26
        for c in p:
            pcount[ord(c)-ord('a')] += 1
        diff = len(p)
        for i in range(len(p)):
            pcount[ord(s[i]) - ord('a')] -= 1
            if pcount[ord(s[i]) - ord('a')] >= 0:
                diff -= 1
        ans = []
        plen = len(p)
        if diff == 0:
            ans.append(0)
        for i in range(plen, len(s)):
            c = s[i-plen]
            pcount[ord(c) - ord('a')] += 1
            if pcount[ord(c) - ord('a')] > 0:
                diff += 1
            c = s[i]
            pcount[ord(c) - ord('a')] -= 1
            if pcount[ord(c) - ord('a')] >= 0:
                diff -= 1
            if diff == 0:
                ans.append(i-plen+1)
        return ans