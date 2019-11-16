class Solution {
    public int evalRPN(String[] tokens) {
        HashSet<String> ops = new HashSet<>();
        ops.add("+");
        ops.add("-");
        ops.add("*");
        ops.add("/");
        Deque<Integer> stack = new ArrayDeque<>();
        for (String t : tokens) {
            if (ops.contains(t)) {
                int n2 = stack.pop();
                int n1 = stack.pop();
                int res = 0;
                if (t.equals("+")) {
                    res = n1 + n2;
                } else if (t.equals("-")) {
                    res = n1 - n2;
                } else if (t.equals("*")) {
                    res = n1 * n2;
                } else {
                    res = n1 / n2;
                }
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
}