/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
/**
 * BFS solution
 * Time O(n)
 * Space O(n)
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<Integer> ans = new ArrayList<>();
        int sum = 0;
        List<NestedInteger> next;
        while (nestedList.size() > 0) {
            next = new ArrayList<>();
            for (NestedInteger i : nestedList) {
                if (i.isInteger()) {
                    sum += i.getInteger();
                } else {
                    next.addAll(i.getList());
                }
            }
            ans.add(sum);
            nestedList = next;
        }
        if (ans.size()==0) {
            return 0;
        } else {
            sum = 0;
            for (int i : ans) {
                sum += i;
            }
        }
        return sum;
    }
}