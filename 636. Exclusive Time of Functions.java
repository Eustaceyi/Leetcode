class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();
        int prev = 0;
        for (String log : logs) {
            String[] l = log.split(":");
            if (l[1].equals("start")) {
                if (!s.empty()) {
                    ans[s.peek()] += Integer.parseInt(l[2]) - prev;
                }
                s.push(Integer.parseInt(l[0]));
                prev = Integer.parseInt(l[2]);
            } else {
                ans[s.peek()] += Integer.parseInt(l[2]) - prev + 1;
                s.pop();
                prev = Integer.parseInt(l[2])+1;
            }
        }
        return ans;
    }
}