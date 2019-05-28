class Solution:
    def myAtoi(self, str: str) -> int:
        '''
        remember to do str.lstrip() first, this is to reduce the leading ' '.
        '''
        str = str.lstrip()
        if not str:
            return 0
        sign = 1
        i = 0
        if str[0] == '+' or str[0] == '-':
            if len(str) == 1:
                return 0
            else:
                sign = 1 if str[0] == '+' else -1
                str = str[1:]
        while i < len(str) and str[i].isdigit():
            i += 1
        ret = sign * int(str[0:i] if i > 0 else 0)
        if ret < -2 ** 31:
            return -2 ** 31
        elif ret > 2**31 - 1:
            return 2**31 - 1
        else:
            return ret