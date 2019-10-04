class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dm = new ListNode(0);
        ListNode node = dm;
        int index = 0;
        int count = 0;
        while (count < lists.length) {
            count = 0;
            int smallest = Integer.MAX_VALUE;
            for (int i=0; i<lists.length; i++) {
                if (lists[i] == null) {
                    count++;
                    continue;
                }
                if (smallest > lists[i].val) {
                    smallest = lists[i].val;
                    index = i;
                }
            }
            if (lists[index] != null) {
                node.next = lists[index];
                node = node.next;
                lists[index] = lists[index].next;
            }
        }
        return dm.next;
    }
}

class Solution {
    /**
     * Using PriorityQueue to pick out the smallest one in the list and merge them.
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> cmp;
        cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        };
        
        Queue<ListNode> q = new PriorityQueue<ListNode>(cmp);
        for (ListNode l : lists) {
            if (l != null) {
                q.add(l);
            }
        }
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (!q.isEmpty()) {
            node.next = q.poll();
            node = node.next;
            if (node.next != null) {
                q.add(node.next);
            }
        }
        return head.next;
    }
}