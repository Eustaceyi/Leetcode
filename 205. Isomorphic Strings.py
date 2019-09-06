class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        dics = {}
        dict = {}
        for i in range(len(s)):
            if s[i] in dics and t[i] in dict:
                if dics[s[i]] != t[i]:
                    return False
                if dict[t[i]] != s[i]:
                    return False
            elif s[i] not in dics and t[i] not in dict:
                dics[s[i]] = t[i]
                dict[t[i]] = s[i]
            elif t[i] not in dict:
                if dics[s[i]] != t[i]:
                    return False
                dict[t[i]] = s[i]
            else:
                if dict[t[i]] != s[i]:
                    return False
                dics[s[i]] = t[i]
        return True