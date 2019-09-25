class Solution:
    def isUgly(self, num: int) -> bool:
        if num == 1:
            return True
        if num == 0:
            return False
        while num != 1:
            if num % 5 != 0:
                if num % 3 != 0:
                    if num % 2 != 0:
                        return False
                    else:
                        num = num / 2
                else:
                    num = num / 3
            else:
                num = num / 5
        return True