class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0
        else:
            head = 0
            tolmax = 0
            char_dict = {}
            for i, char in enumerate(s):
                if char in char_dict and head <= char_dict[char]:
                    head = char_dict[char] + 1
                char_dict[char] = i
                if tolmax < i - head + 1:
                    tolmax = i - head + 1
            return tolmax