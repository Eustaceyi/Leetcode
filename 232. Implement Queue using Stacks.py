from queue import LifoQueue

class MyQueue:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack1 = LifoQueue()
        self.stack2 = LifoQueue()
        self.size = 0

    def push(self, x: int) -> None:
        """
        Push element x to the back of queue.
        """
        self.stack1.put(x)
        self.size += 1

    def pop(self) -> int:
        """
        Removes the element from in front of queue and returns that element.
        """
        for i in range(self.size-1):
            self.stack2.put(self.stack1.get())
        ret = self.stack1.get()
        self.size -= 1
        for i in range(self.size):
            self.stack1.put(self.stack2.get())
        return ret

    def peek(self) -> int:
        """
        Get the front element.
        """
        for i in range(self.size-1):
            self.stack2.put(self.stack1.get())
        ret = self.stack1.get()
        self.stack2.put(ret)
        for i in range(self.size):
            self.stack1.put(self.stack2.get())
        return ret

    def empty(self) -> bool:
        """
        Returns whether the queue is empty.
        """
        return not self.size


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()