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
 * O(n) time
 * O(n) space
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int sum = 0;
        int level = 1;
        List<NestedInteger> nextLevel;
        while (nestedList.size() > 0) {
            nextLevel = new ArrayList<>();
            for (NestedInteger l : nestedList) {
                if (l.isInteger()) {
                    sum += level * l.getInteger();
                } else {
                    nextLevel.addAll(l.getList());
                }
            }
            level++;
            nestedList = nextLevel;
        }
        return sum;
    }
}
/**
 * DFS solution
 * O(n) time
 * O(n) space 
 */
class Solution {
    int sum;
    public int depthSum(List<NestedInteger> nestedList) {
        sum = 0;
        calSum(nestedList, 1);
        return sum;
    }
    private void calSum(List<NestedInteger> nl, int level) {
        for (NestedInteger i : nl) {
            if (i.isInteger()) {
                sum += level * i.getInteger();
            } else {
                calSum(i.getList(), level+1);
            }
        }
    }
}