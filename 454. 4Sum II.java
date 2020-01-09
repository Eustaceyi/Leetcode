/**
 * if we use brute force, we could make it O(n^4)
 * to make it more efficient, we could use a hashmap to store previous sum of 2 array
 * and check them later with other 2 array, this could reduce it to O(n^2)
 */
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<A.length; i++) {
            for (int j=0; j<B.length; j++) {
                map.put(A[i]+B[j], map.getOrDefault(A[i]+B[j], 0)+1);
            }
        }
        
        int res = 0;
        for (int i=0; i<C.length; i++) {
            for (int j=0; j<D.length; j++) {
                res += map.getOrDefault(-(C[i]+D[j]), 0);
            }
        }
        return res;
    }
}