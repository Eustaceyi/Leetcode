class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        digits = [0 for i in range(len(num1)+len(num2))]
        r1 = num1[::-1]
        r2 = num2[::-1]
        for i in range(len(r1)):
            for j in range(len(r2)):
                digits[i + j] += int(r1[i]) * int(r2[j])
                digits[i + j + 1] += digits[i + j] // 10
                digits[i + j] %= 10
        while len(digits) > 1 and digits[-1] == 0: 
            digits.pop()
        return ''.join(map(str,digits[::-1]))