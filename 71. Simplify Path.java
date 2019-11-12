class Solution {
    public String simplifyPath(String path) {
        String[] part = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String s : part) {
            if (s.equals("") || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if (stack.isEmpty()) {
                    continue;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
            if (!stack.isEmpty()) {
                sb.append("/");
            }
        }
        return sb.toString();
    }
}