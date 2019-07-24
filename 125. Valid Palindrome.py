class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = "".join([ch for ch in s if ch.isalpha() or ch.isdigit()]).lower()
        return s == s[::-1]

class Solution:
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        import string
        if not s:
            return True
        else:
            punc = set(string.punctuation)
            s = ''.join(ch for ch in s if ch not in punc)
            s = s.replace(' ','')
            s = s.lower()
            if s == s[::-1]:
                return True
            else:
                return False