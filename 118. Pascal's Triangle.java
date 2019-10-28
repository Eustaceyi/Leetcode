class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows==0) {
            return ans;
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        ans.add(new ArrayList(temp));
        if (numRows==1) {
            return ans;
        }
        for (int i=1;i<numRows; i++) {
            List<Integer> last = ans.get(i-1);
            temp = new ArrayList<>();
            temp.add(1);
            for (int j=1; j<i; j++) {
                temp.add(last.get(j-1)+last.get(j));
            }
            temp.add(1);
            ans.add(new ArrayList(temp));
        }
        return ans;
    }
}