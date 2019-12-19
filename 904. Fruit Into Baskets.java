class Solution {
    public int totalFruit(int[] tree) {
        Integer b1=null, b2=null;
        int total=0, c1=0, c2=0, temp=0;
        for (int i : tree) {
            if (b1 == null) {
                b1 = i;
                temp++;
            } else if (b2 == null) {
                if (i == b1) {
                    temp++;
                } else {
                    b2 = b1;
                    c2 = temp;
                    b1 = i;
                    c1 = 0;
                    temp = 1;
                }
            } else {
                if (i == b1) {
                    temp++;
                } else if (i == b2) {
                    int t = b2;
                    b2 = b1;
                    b1 = t;
                    t = c2;
                    c2 = c1 + temp;
                    c1 = t;
                    temp = 1;
                } else {
                    b2 = b1;
                    c2 = temp;
                    b1 = i;
                    c1 = 0;
                    temp = 1;
                }
            }
            total = Math.max(total, c1 + c2 + temp);
        }
        return total;
    }
}