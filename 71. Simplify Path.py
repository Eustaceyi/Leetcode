class Solution:
    def simplifyPath(self, path: str) -> str:
        temp = [word for word in path.strip().split('/') if word and word != '.']
        ls = []
        for word in temp:
            if word == '..':
                if ls: ls.pop(-1)
            else:
                ls.append(word)
        return '/'+'/'.join(ls)