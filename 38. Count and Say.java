class Solution {
    public String countAndSay(int n) {
        String ans = "1";
        if (n==1) {
            return ans;
        }
        int count = 0;
        char c = '1';
        for (int i=1; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            count = 0;
            c = '1';
            for (int j=0; j<ans.length(); j++) {
                if (c == ans.charAt(j)) {
                    count++;
                } else {
                    if (count == 0) {
                        c = ans.charAt(j);
                        count = 1;
                    } else {
                        sb.append(Integer.toString(count));
                        sb.append(c);
                        c = ans.charAt(j);
                        count = 1;
                    }
                }
            }
            sb.append(Integer.toString(count));
            sb.append(c);
            ans = sb.toString();
        }
        return ans;
    }
}