class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i : asteroids) {
            if (i < 0) {
                boolean isBreak = false;
                while (!stack.isEmpty() && stack.peek() > 0) {
                    if (i < -1 * stack.peek()) {
                        stack.pop();
                    } else {
                        if (i == -1 * stack.peek()) {
                            stack.pop();
                        }
                        isBreak = true;
                        break;
                    }
                }
                if (!isBreak) {
                    stack.push(i);
                }
            } else {
                stack.push(i);
            }
        }
        int[] ans = new int[stack.size()];
        for (int i=0; i<ans.length; i++) {
            ans[i] = stack.pollLast();
        }
        return ans;
    }
}