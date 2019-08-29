class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        ops = ['+', '-', '*', '/']
        for token in tokens:
            if token not in ops:
                stack.append(int(token))
            else:
                a = stack.pop()
                b = stack.pop()
                if token == '+':
                    stack.append(b+a)
                elif token == '-':
                    stack.append(b-a)
                elif token == '*':
                    stack.append(b*a)
                elif token == '/':
                    if a*b < 0:
                        stack.append(-(b//-a))
                    else:
                        stack.append(b//a)
        return stack[-1]