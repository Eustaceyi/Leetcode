class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String p : paths) {
            String[] ps = p.split(" ");
            String filepath = ps[0];
            for (int i=1; i<ps.length; i++) {
                String[] con = ps[i].split("\\(");
                String context = con[1].substring(0, con[1].length()-1);
                if (!map.containsKey(context)) {
                    map.put(context, new ArrayList<>());
                }
                map.get(context).add(filepath + '/' + con[0]);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> l : map.values()) {
            if (l.size() > 1) {
                ans.add(l);
            }
        }
        return ans;
    }
}