class Solution:
    def convert(self, s: str, numRows: int) -> str:
        if numRows == 1 or numRows >= len(s):
            return s
        store = []
        for i in range(numRows):
            store.append('')
        flag = 1
        pos = 1
        for i, r in enumerate(s):
            if pos == 1:
                flag = 1
            elif pos == numRows:
                flag = -1
            store[pos-1] += r
            pos += flag
        return ''.join(store)