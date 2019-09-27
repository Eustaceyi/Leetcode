class Solution:
    def addDigits(self, num: int) -> int:
        return num % 9 or 9 if num else 0

class Solution:
    def addDigits(self, num):
        while num>9:
            num=sum(int(c) for c in str(num))
        return num