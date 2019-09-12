class Solution:
    def calculate(self, s: str) -> int:
        stack = []
        idx = 0
        sign = 1
        output = 0
        number = 0
        while idx < len(s):
            char = s[idx]
            if char == ' ':
                idx += 1
            elif char == '+':
                output += sign * number
                number = 0
                sign = 1
                idx += 1
            elif char == '-':
                output += sign * number
                number = 0
                sign = -1
                idx += 1
            elif char == '*':
                temp = 0
                idx += 1
                while idx < len(s) and (s[idx] == ' ' or s[idx].isdigit()):
                    if s[idx] == ' ':
                        idx += 1
                    else:
                        temp = temp*10 + int(s[idx])
                        idx += 1
                number *= temp
            elif char == '/':
                temp = 0
                idx += 1
                while idx < len(s) and (s[idx] == ' ' or s[idx].isdigit()):
                    if s[idx] == ' ':
                        idx += 1
                    else:
                        temp = temp*10 + int(s[idx])
                        idx += 1
                if number * temp < 0:
                    number = number // temp + 1
                else:
                    number = number // temp
            elif char.isdigit():
                number = number*10 + int(char)
                idx += 1
                while idx< len(s) and s[idx].isdigit():
                    number = number*10 + int(s[idx])
                    idx += 1
        return output + sign * number