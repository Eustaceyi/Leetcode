class TwoSum:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.numbers = {}

    def add(self, number: int) -> None:
        """
        Add the number to an internal data structure..
        """
        if number in self.numbers:
            self.numbers[number] += 1
        else:
            self.numbers[number] = 1

    def find(self, value: int) -> bool:
        """
        Find if there exists any pair of numbers which sum is equal to the value.
        """
        for n in self.numbers:
            if value - n in self.numbers and (value != 2*n or self.numbers[n] >= 2):
                return True
        return False


# Your TwoSum object will be instantiated and called as such:
# obj = TwoSum()
# obj.add(number)
# param_2 = obj.find(value)