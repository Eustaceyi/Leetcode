/**
 * Use fast slow pointer to detect loop
 * Time O(n)
 * Space O(1)
 */
class Solution {
    private int n;
    private int[] ns;
    
    // this function makes sure that we could find the next index
    private int next(int i) {
        return ((i + ns[i]) % n + n) % n;
    }
    
    public boolean circularArrayLoop(int[] nums) {
        // handle edge cases
        if (nums==null || nums.length < 2) {
            return false;
        }
        this.ns = nums; this.n = ns.length;
        for (int i=0; i<n; i++) {
            // if we meet 0 forward we skip
            if (ns[i] == 0) {
                continue;
            }
            // fast slow pointer to detect
            int slow = i, fast = next(i);
            while (slow != fast) {
                // if we meet direction change we stop
                if (ns[slow] * ns[fast] < 0 || ns[slow] * ns[next(fast)] < 0) {
                    break;
                } 
                slow = next(slow);
                fast = next(next(fast));
            }
            // when we stop, we should check if it detect a loop
            if (slow == fast) {
                // if the loop contians only one element, we ignore it
                if (slow != next(slow)) {
                    return true;
                }
            }
            // we should change all seen same direction element into 0
            // this could help with not checking them again
            slow = i;
            while (ns[slow] * ns[next(slow)] > 0) {
                int next = next(slow);
                ns[slow] = 0;
                slow = next;
            }
        }
        return false;
    }
}