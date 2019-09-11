from queue import Queue

class MyStack:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.queue = Queue()
        self.size = 0

    def push(self, x: int) -> None:
        """
        Push element x onto stack.
        """
        self.queue.put(x)
        self.size += 1

    def pop(self) -> int:
        """
        Removes the element on top of the stack and returns that element.
        """
        for i in range(self.size-1):
            temp = self.queue.get()
            self.queue.put(temp)
        temp = self.queue.get()
        self.size -= 1
        return temp
    
    def top(self) -> int:
        """
        Get the top element.
        """
        for i in range(self.size):
            temp = self.queue.get()
            self.queue.put(temp)
        return temp

    def empty(self) -> bool:
        """
        Returns whether the stack is empty.
        """
        return self.size == 0


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()