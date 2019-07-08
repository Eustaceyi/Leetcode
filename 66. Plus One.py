class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        for i in range(len(digits)-1, -1, -1):
            carry, digits[i] = divmod(digits[i]+1, 10)
            print(carry)
            print(digits[i])
            if not carry:
                return digits
        digits.insert(0,1)
        return digits