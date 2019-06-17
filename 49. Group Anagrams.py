class Solution:
    def groupAnagrams(self, strs):
        dic = {}
        for s in strs:
            key = ''.join(sorted(s))
            dic[key] = dic.get(key, []) + [s]
        return list(dic.values())