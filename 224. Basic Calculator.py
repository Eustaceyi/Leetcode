class Solution:
    def calculate(self, s: str) -> int:

        stack = []
        operand = 0
        res = 0 # For the on-going result
        sign = 1 # 1 means positive, -1 means negative  

        for ch in s:
            if ch.isdigit():

                # Forming operand, since it could be more than one digit
                operand = (operand * 10) + int(ch)

            elif ch == '+':

                # Evaluate the expression to the left,
                # with result, sign, operand
                res += sign * operand

                # Save the recently encountered '+' sign
                sign = 1

                # Reset operand
                operand = 0

            elif ch == '-':

                res += sign * operand
                sign = -1
                operand = 0

            elif ch == '(':

                # Push the result and sign on to the stack, for later
                # We push the result first, then sign
                stack.append(res)
                stack.append(sign)

                # Reset operand and result, as if new evaluation begins for the new sub-expression
                sign = 1
                res = 0

            elif ch == ')':

                # Evaluate the expression to the left
                # with result, sign and operand
                res += sign * operand

                # ')' marks end of expression within a set of parenthesis
                # Its result is multiplied with sign on top of stack
                # as stack.pop() is the sign before the parenthesis
                res *= stack.pop() # stack pop 1, sign

                # Then add to the next operand on the top.
                # as stack.pop() is the result calculated before this parenthesis
                # (operand on stack) + (sign on stack * (result from parenthesis))
                res += stack.pop() # stack pop 2, operand

                # Reset the operand
                operand = 0

        return res + sign * operand

class Solution:
    def calculate(self, s: str) -> int:
        '''
        My naive solution
        '''
        stack = []
        idx = 0
        while idx < len(s):
            char = s[idx]
            if char in '(-+':
                stack.append(char)
                idx += 1
            elif char == ' ':
                idx += 1
            elif char.isdigit():
                toappend = 0
                while idx < len(s) and s[idx].isdigit():
                    toappend = toappend*10 + int(s[idx])
                    idx += 1
                stack.append(toappend)
            elif char == ')':
                number = stack.pop(-1)
                if number == '(':
                    idx += 1
                    continue
                else:
                    toappend = 0
                    temp = 0
                    while number != '(':
                        if number == '+':
                            toappend += temp
                            temp = 0
                            number = stack.pop(-1)
                        elif number == '-':
                            toappend -= temp
                            temp = 0
                            number = stack.pop(-1)
                        else:
                            temp = number
                            number = stack.pop(-1)
                    toappend += temp
                    stack.append(toappend)
                idx += 1
        
        result = 0
        sign = 1
        
        while stack:
            number = stack.pop(0)
            if number == '-':
                sign = -1
            elif number == '+':
                sign = 1
            else:
                result += sign * number
        return result