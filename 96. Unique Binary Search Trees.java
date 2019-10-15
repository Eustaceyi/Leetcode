class Solution {
    /**
     * Consider the previous question, we think of Cn+1 = sum(Ci * Cn-i)
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n == 0 || n==1) {
            return 1;
        }
        List<Integer> number = new LinkedList<>();
        number.add(1);
        number.add(1);
        for (int i=1; i<n; i++) {
            int temp = 0;
            for(int j=0; j<=i; j++) {
                temp += number.get(j) * number.get(i-j);
            }
            number.add(temp);
        }
        return number.get(n);
    }
}