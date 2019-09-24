class Solution {
    private List<String> ans = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        genPar("", n, n);
        return this.ans;
    }
    
    private void genPar(String s, int left, int right) {
        if (left == 0 && right == 0) {
            this.ans.add(s);
            return;
        } 
        if (left > right || left < 0 || right < 0) {
            return;
        } else {
            genPar(s+'(', left-1, right);
            genPar(s+')', left, right-1);
        }
    }
}