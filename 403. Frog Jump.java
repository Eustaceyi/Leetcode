/**
 * regular dp solution,
 * Time complexity : O(n^2). Two nested loops are there.
 * Space complexity : O(n^2). hashmaphashmap size can grow upto n^2.
 */
public class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }
}

/**
 * Advanced dp using stack
 */
class Solution {
    public boolean canCross(int[] stones) {
        
        // this is important, since remove this will cause TLE,
        // because if the next stone is larger than 2x current stone,
        // there will be no way to go there
        for(int i=3; i<stones.length; i++) {
            if(stones[i] > stones[i-1]*2) {
                return false;
            }
        }
        
        // for recording all stone for looking up
        Set<Integer> stonePositions = new HashSet();
        for(int stone : stones) {
            stonePositions.add(stone);
        }
        
        int lastStone = stones[stones.length - 1];
        Stack<Integer> positions = new Stack<>();
        Stack<Integer> jumps = new Stack<>();
        positions.add(0);
        jumps.add(0);
        
        // checking all the stones
        while(!positions.isEmpty()) {
            int position = positions.pop();
            int jumpDistance = jumps.pop();
            // check k-1, k, k+1
            for(int i=jumpDistance-1; i <= jumpDistance+1; i++) {
                if(i <= 0) {
                    continue;
                }
                int nextPosition = position+i;
                if(nextPosition == lastStone){
                    return true;
                } else if (stonePositions.contains(nextPosition)) {
                    positions.add(nextPosition);
                    jumps.add(i);
                }
            }
        }
        return false;
    }
}