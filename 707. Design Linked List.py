class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class MyLinkedList:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.length = 0
        self.head = None
        

    def get(self, index: int) -> int:
        """
        Get the value of the index-th node in the linked list. If the index is invalid, return -1.
        """
        if index < 0 or index >= self.length or not self.head:
            return -1
        i = 0
        ret = self.head
        while i < index:
            ret = ret.next
            i += 1
        return ret.val

    def addAtHead(self, val: int) -> None:
        """
        Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
        """
        temp = ListNode(val)
        temp.next = self.head
        self.head = temp
        self.length += 1

    def addAtTail(self, val: int) -> None:
        """
        Append a node of value val to the last element of the linked list.
        """
        if not self.head:
            self.addAtHead(val)
            return
        head = self.head
        while head.next:
            head = head.next
        head.next = ListNode(val)
        self.length += 1

    def addAtIndex(self, index: int, val: int) -> None:
        """
        Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
        """
        if index > self.length:
            return
        if index <= 0:
            self.addAtHead(val)
            return
        if index == self.length:
            self.addAtTail(val)
            return
        i = 0
        ret = self.head
        while i < index - 1:
            ret = ret.next
            i += 1
        temp = ListNode(val)
        temp.next = ret.next
        ret.next = temp
        self.length += 1

    def deleteAtIndex(self, index: int) -> None:
        """
        Delete the index-th node in the linked list, if the index is valid.
        """
        if index < 0 or index >= self.length:
            return
        prev = None
        curr = self.head
        i = 0
        while i < index:
            prev = curr
            curr = curr.next
            i += 1
        if not prev:
            self.head = self.head.next
        else:
            prev.next = curr.next
            self.length -= 1


# Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)