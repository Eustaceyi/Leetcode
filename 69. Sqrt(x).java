class Solution {
    public int mySqrt(int x) {
        if (x>=0 && x<=1) return x;
        int st = 2, ed = x;
        while (st <= ed) {
            int mid = (ed-st)/2 + st;
            if (mid == x/mid) {
                return mid;
            } else if (mid < x/mid) {
                st = mid+1;
            } else {
                ed = mid-1;
            }
        }
        return ed;
    }
}

class Solution {
    public int mySqrt(int x) {
        if (x>=0 && x<=1) return x;
        double x0 = x;
        double x1 = (x / x0 + x0) / 2.0;
        while (Math.abs(x1 - x0) >=1) {
            x0 = x1; 
            x1 = (x / x0 + x0) / 2.0;
        }
        return (int) x1;
    }
}