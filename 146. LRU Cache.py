class LRUNode:
    def __init__(self, key, value, prev, next):
        self.key = key
        self.value = value
        self.prev = prev
        self.next = next
        
class LRUCache:

    def __init__(self, capacity: int):
        self.head = None
        self.tail = None
        self.capacity = capacity
        self.curr = 0
        self.dic = {}

    def get(self, key: int) -> int:
        if key in self.dic:
            if self.dic[key] is self.head:
                return self.dic[key].value
            elif self.dic[key] is self.tail:
                self.tail = self.tail.prev
                self.tail.next = None
                self.dic[key].next = self.head
                self.dic[key].prev = None
                self.head.prev = self.dic[key]
                self.head = self.dic[key]
            else:
                tn, tp = self.dic[key].next, self.dic[key].prev
                self.dic[key].prev = None
                self.dic[key].next = self.head
                self.head.prev = self.dic[key]
                self.head = self.dic[key]
                tn.prev = tp
                tp.next = tn
            return self.dic[key].value
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        if key in self.dic:
            if self.head is self.dic[key]:
                self.dic[key].value = value
                return
            elif self.tail is self.dic[key]:
                self.tail = self.tail.prev
                self.tail.next = None
                self.dic[key].next = self.head
                self.dic[key].prev = None
                self.head.prev = self.dic[key]
                self.head = self.dic[key]
                self.dic[key].value = value
                return
            else:
                tn, tp = self.dic[key].next, self.dic[key].prev
                self.dic[key].prev = None
                self.dic[key].next = self.head
                self.head.prev = self.dic[key]
                self.head = self.dic[key]
                self.dic[key].value = value
                tn.prev = tp
                tp.next = tn
                return
        else:
            if self.curr < self.capacity:
                if self.curr == 0:
                    node = LRUNode(key, value, None, None)
                    self.head = node
                    self.tail = node
                    self.dic[key] = node
                    self.curr += 1
                else:
                    node = LRUNode(key, value, None, self.head)
                    self.head.prev = node
                    self.head = node
                    self.dic[key] = node
                    self.curr += 1
            else:
                node = LRUNode(key, value, None, self.head)
                self.head.prev = node
                self.head = node
                self.dic.pop(self.tail.key)
                self.tail = self.tail.prev
                self.tail.next = None
                self.dic[key] = node
            return


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)


from collections import OrderedDict
class LRUCache(OrderedDict):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity = capacity

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key not in self:
            return - 1
        
        self.move_to_end(key)
        return self[key]

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: void
        """
        if key in self:
            self.move_to_end(key)
        self[key] = value
        if len(self) > self.capacity:
            self.popitem(last = False)

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)