/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

      public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int st=1, ed=n;
            while (st < ed) {
                int mid = (ed-st)/2+st;
                if (isBadVersion(mid)) {
                    ed = mid;
                } else {
                    st = mid+1;
                }
            }
            return st;
        }
    }