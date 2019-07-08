class Solution:
    def addBinary(self, a, b):
        res, carry = '', 0
        i, j = len(a) - 1, len(b) - 1
        while i >= 0 or j >= 0 or carry:
            curval = (i >= 0 and a[i] == '1') + (j >= 0 and b[j] == '1')
            carry, rem = divmod(curval + carry, 2)
            res = str(rem) + res
            i -= 1
            j -= 1
        return res

class Solution:
    def addBinary(self, a: str, b: str) -> str:
        a, b = a[::-1], b[::-1]
        res = ''
        carry = 0
        
        for i in range(min(len(a),len(b))):
            carry, r = divmod(int(a[i])+int(b[i])+carry, 2)
            res += str(r)
        if len(a) > len(b):
            for i in range(len(b),len(a)):
                carry, r = divmod(int(a[i])+carry, 2)
                res += str(r)
            if carry:
                res += '1'
        else:
            for i in range(len(a),len(b)):
                carry, r = divmod(int(b[i])+carry, 2)
                res += str(r)
            if carry:
                res += '1'
        return res[::-1]