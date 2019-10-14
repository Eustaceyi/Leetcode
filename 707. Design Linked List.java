class MyLinkedList {
    private class Node {
        public int val;
        public Node next;
        public Node prev;
        public Node(int val) {
            this.val = val;
        }
    }
    private Node head;
    private Node tail;
    private int length;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= this.length || index < 0) {
            return -1;
        }
        Node node;
        int step;
        if (index >= length/2) {
            node = this.tail;
            step = this.length-1-index;
            for (int i=0;i<step;i++) {
                node = node.prev;
            }
        } else {
            node = this.head;
            step = index;
            for (int i=0;i<step;i++) {
                node = node.next;
            }
        }
        return node.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (this.head == null) {
            Node node = new Node(val);
            this.head = node;
            this.tail = node;
            this.length++;
        } else {
            Node node = new Node(val);
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
            this.length++;
        }
        
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (this.tail == null) {
            Node node = new Node(val);
            this.head = node;
            this.tail = node;
            this.length++;
        } else {
            Node node = new Node(val);
            node.prev = this.tail;
            this.tail.next = node;
            this.tail = node;
            this.length++;
        }
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > this.length) {
            return;
        }
        if (index <= 0) {
            addAtHead(val);
        } else if (index == this.length) {
            addAtTail(val);
        } else {
            Node node = this.head;
            for (int i=0;i<index;i++) {
                node = node.next;
            }
            Node toInsert = new Node(val);
            Node prev = node.prev;
            prev.next = toInsert;
            toInsert.prev = prev;
            node.prev = toInsert;
            toInsert.next = node;
            this.length++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= this.length) {
            return;
        }
        if (this.length == 1) {
            this.head = null;
            this.tail = null;
            this.length--;
        } else {
            if (index == 0) {
                this.head = this.head.next;
                this.head.prev = null;
                this.length--;
            }
            else if (index == this.length-1) {
                this.tail = this.tail.prev;
                this.tail.next = null;
                this.length--;
            }
            else {
                Node node = this.head;
                for (int i=0;i<index;i++) {
                    node = node.next;
                }
                Node prev = node.prev, next = node.next;
                if (prev != null) {
                    prev.next = next;
                }
                if (next != null) {
                    next.prev = prev;
                }
                node.next = null;
                node.prev = null;
                this.length--;
            }
        }
        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */