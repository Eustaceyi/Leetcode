class Logger:
    '''
    This problem we should consider the space that we use to store the messages,
    so we should keep what is inputed in the last 10 seconds,
    and we should delete all previous messages
    '''
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.printed = set()
        self.queue = collections.deque()
        

    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        """
        while self.queue and timestamp - self.queue[-1][0] >= 10:
            poped_t, poped_m = self.queue.pop()
            self.printed.remove(poped_m)
            
        if message in self.printed:
            return False
        else:
            self.queue.appendleft((timestamp, message))
            self.printed.add(message)
            return True