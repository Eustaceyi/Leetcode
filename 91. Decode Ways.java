/**
 * dp solution
 * Time O(n)
 * Space O(n)
 */
class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {return 0;}
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=1; i<s.length(); i++) {
            int temp = Integer.parseInt(s.substring(i-1, i+1));
            if (temp <= 26 && temp >= 10) {
                dp[i+1] += dp[i-1]; 
            }
            if (s.charAt(i) != '0') {
                dp[i+1] += dp[i];
            }
        }
        return dp[s.length()];
    }
}
/**
 * DFS with memo
 */
class Solution {
    public int numDecodings(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        return helper(s, map);
    }
    private int helper(String s, HashMap<String, Integer> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (s.length()==1 && s.equals("0")) {return 0;}
        if (s.length() == 0 || s.length() == 1) {return 1;}
        int ans = 0;
        int temp = Integer.parseInt(s.substring(0,2));
        if (temp >= 10 && temp <= 26){
            ans += helper(s.substring(2), map);
        }
        if (s.charAt(0) != '0') {
            ans += helper(s.substring(1), map);
        }
        map.put(s, ans);
        return ans;
    }
}