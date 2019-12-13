class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            String[] ss = s.split(" ");
            int count = Integer.parseInt(ss[0]);
            String domain = ss[1];
            map.put(domain, map.getOrDefault(domain, 0)+count);
            int index;
            while ((index = domain.indexOf('.')) != -1) {
                domain = domain.substring(index+1);
                map.put(domain, map.getOrDefault(domain, 0)+count);
            }
        }
        List<String> ans = new ArrayList<>();
        for (String s : map.keySet()) {
            ans.add(map.get(s) + " " + s);
        }
        return ans;
    }
}