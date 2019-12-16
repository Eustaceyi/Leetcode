class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for (String e : emails) {
            String[] ep = e.split("@");
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<ep[0].length(); i++) {
                if (ep[0].charAt(i) == '.') {
                    continue;
                } else if (ep[0].charAt(i) == '+') {
                    break;
                } else {
                    sb.append(ep[0].charAt(i));
                }
            }
            set.add(sb.toString() + "@" + ep[1]);
        }
        return set.size();
    }
}