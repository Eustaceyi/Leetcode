class Solution {
    public List<String> restoreIpAddresses(String s) {
        if (s==null || s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        backtrack(s, 4, new ArrayList<>(), ans);
        return ans;
    }
    private void backtrack(String s, int left, List<String> curr, List<String> ans) {
        if (s.length() < left || s.length() > 3*left) {
            return;
        }
        if (left==0 && s.equals("")) {
            ans.add(String.join(".", curr));
            return;
        }
        String t1 = s.substring(0,1);
        curr.add(t1);
        backtrack(s.substring(1), left-1, curr, ans);
        curr.remove(curr.size()-1);
        
        if (s.length() < 2) {return;}
        
        t1 = s.substring(0,2);
        int t2 = Integer.parseInt(t1);
        if (t2 > 9) {
            curr.add(t1);
            backtrack(s.substring(2), left-1, curr, ans);
            curr.remove(curr.size()-1);
        }
        
        if (s.length() < 3) {return;}
        
        t1 = s.substring(0,3);
        t2 = Integer.parseInt(t1);
        if (t2 > 99 && t2 < 256) {
            curr.add(t1);
            backtrack(s.substring(3), left-1, curr, ans);
            curr.remove(curr.size()-1);
        }
    }
}