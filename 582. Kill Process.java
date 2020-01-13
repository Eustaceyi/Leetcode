class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<pid.size(); i++) {
            map.computeIfAbsent(ppid.get(i), (key -> new ArrayList<>())).add(pid.get(i));
        }
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(kill);
        while (!dq.isEmpty()) {
            int process = dq.poll();
            ans.add(process);
            if (map.containsKey(process)) {
                for (int child : map.get(process)) {
                    dq.offer(child);
                }
            }
        }
        return ans;
    }
}