/**
 * HashMap + DLL
 */
class LRUCache {
    class Node {
        public int key;
        public int value;
        public Node next;
        public Node prev;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    Node head, tail;
    int size;
    int capacity;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        this.size = 0;
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if (n==null) {
            return -1;
        }
        Node prev=n.prev, next=n.next;
        prev.next=next;
        next.prev=prev;
        Node hn = head.next;
        n.prev = head;
        head.next = n;
        hn.prev = n;
        n.next = hn;
        return n.value;
    }
    
    public void put(int key, int value) {
        Node curr = map.get(key);
        if (curr==null) {
            Node newNode = new Node(key,value);
            map.put(key, newNode);
            if (size==capacity) {
                tail = tail.prev;
                map.remove(tail.key);
                size--;
            }  
            Node hn = head.next;
            newNode.prev = head;
            head.next = newNode;
            hn.prev = newNode;
            newNode.next = hn;
            size++;
        } else {
            Node p=curr.prev, n=curr.next;
            p.next = n;
            n.prev = p;
            curr.value = value;
            Node hn = head.next;
            curr.prev = head;
            head.next = curr;
            hn.prev = curr;
            curr.next = hn;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */