class STNode {
    int min, max, sum;
    STNode left, right;
    STNode(int min, int max, int sum, STNode left, STNode right) {
        this.min = min;
        this.max = max;
        this.sum = sum;
        this.left = left;
        this.right = right;
    }
}

class NumArray {
    STNode root;

    public NumArray(int[] nums) {
        if (nums==null || nums.length==0) {
            return;
        }
        root = build(nums, 0, nums.length-1);
    }
    
    private STNode build(int[] nums, int st, int ed) {
        if (st == ed) {
            return new STNode(st, ed, nums[st], null, null);
        }
        int mid = (ed - st) / 2 + st;
        STNode left = build(nums, st, mid);
        STNode right = build(nums, mid+1, ed);
        return new STNode(st, ed, left.sum+right.sum, left, right);
    }
    
    public void update(int i, int val) {
        update(i, val, root);
    }
    
    private void update(int i, int val, STNode node) {
        if (node.min == i && node.max == i) {
            node.sum = val;
            return;
        }
        int mid = (node.max - node.min)/2+node.min;
        if (mid >= i) {
            update(i, val, node.left);
        } else {
            update(i, val, node.right);
        }
        node.sum = node.left.sum + node.right.sum;
    }
    
    public int sumRange(int i, int j) {
        return sumRange(i, j, root);
    }
    
    private int sumRange(int i, int j, STNode node) {
        if (node.min == i && node.max == j) {
            return node.sum;
        }
        int mid = (node.max - node.min) / 2 + node.min;
        if (j <= mid) {
            return sumRange(i, j, node.left);
        } else if (i > mid) {
            return sumRange(i, j, node.right);
        } else {
            return sumRange(i, mid, node.left) + sumRange(mid+1, j, node.right);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */